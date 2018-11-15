/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chompp;
import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.applet.*;
import java.util.*;

/**
 * A chomp applet. A very simple game.
 * In this game, a position is represented by a
 * bitmask. A bit is set if the position is occupied.
 */
public class Abacus extends Applet implements Runnable {
  private final int xx = 11;
  private final int yy = 5;
  private final String moveMsg = "Click a blue square";
  private final String moveMsgEo = "Alklaku bluan kvadraton";
  private final Color darkGreen = new Color(0, 136, 0);
  private final Integer good = new Integer(8);
  private final Integer rect = new Integer(-6);
  private final Integer look = new Integer(-7);
  private final Integer lose = new Integer(-8);
  private int xoff;
  private int yoff;
  private int y1;
  private int y2;
  private int x2;
  private long[] ymask;
  private Image notImage;
  /** All known positions */
  private Hashtable kp = new Hashtable();
  private String msg = moveMsg;
  private String msgEo = moveMsgEo;
  /** The current position */
  private long cp;
  private int level = 0;
  /** User's move */
  private int ux;
  private int uy;
  /** Computer's move */
  private int mx;
  private int my;
  private boolean thinking = false;

  public String getAppletInfo() {
    return "Chomp Java applet by Mati Pentus";
  }

  /**
   * Initialize the applet. Create images.
   */
  public void init() {
    setBackground(Color.white);
    Dimension d = size();
    xoff = (d.width - 1) / xx;
    yoff = (d.height - 1) / (yy + 1);
    int dy = (int) (0.45 * yoff);
    y1 = yy * yoff + dy;
    y2 = y1 + dy;
    x2 = (int) (d.width * 0.8);
    int[] notBitmap = {
      0, 0, 0, -268435456, -1073741570, 16383,
      1048572, 67108800, -1024, -16384, -262081, -4190209,
      -133955585, -2139095041, 268174335, -16760848, -1073480191, 8372351,
      267915256, -16515328, -528490495, 267911231, -16775172, -1073676543,
      2089023, 133957624, -8323328, -266346496, 66977855, 2143291390,
      -66846848, -100667377, -261633, -8380417, -536608769, 4194303,
      67108856, 1073741312, -32768, -4194301, -536870849, 127};
    notImage = decodeImage(37, 39,
      new Color(51, 18, 217).getRGB(), notBitmap);
    MediaTracker mediaTracker = new MediaTracker(this);
    mediaTracker.addImage(notImage, 0);
    try {
      mediaTracker.waitForAll();
    }
    catch (InterruptedException ex) {
    }
    ymask = new long[yy + 1];
    ymask[0] = 0;
    for (int i = 0; i < yy; i++) {
      ymask[i + 1] = 1L + (1L << xx) * ymask[i];
    }
    cp = pt(xx, yy);
    setMatiKp();
  }

  private Image decodeImage(int w, int h, int fg, int[] bitmap) {
    int[] pix = new int[w * h];
    int n = Math.min(w * h, 32 * bitmap.length);
    for (int i = 0; i < n; i ++) {
      if ((bitmap[i / 32] & (1 << (i % 32))) != 0) {
        pix[i] = fg;
      }
    }
    return createImage(new MemoryImageSource(w, h, pix, 0, w));
  }

  /**
   * Initialize all winning positions.
   */
  private void setMatiKp() {
    kp.clear();
    kp.put(new Long(0), lose);
    for (int i = 0; i < xx; i ++) {
      kp.put(new Long(pt(i, 2) | pt(i + 1, 1)), good);
    }
    for (int i = 2; i < yy; i ++) {
      kp.put(new Long(pt(2, i) | pt(1, i + 1)), good);
    }
    if (level < 2) {
      return;
    }
    for (int i = Math.min(xx, yy); i > 2; i --) {
      kp.put(new Long(pt(i, 1) | pt(1, i)), good);
    }
    if (level < 4) {
      return;
    }
    for (int i = 2; i <= xx; i ++) {
      for (int j = 2; j <= yy; j ++) {
        kp.put(new Long(pt(i, j)), (i == 2 || j == 2) ? look : rect);
      }
    }
    if (level < 6) {
      return;
    } // Add more Mati's heuristics
    for (int i = 4; i <= xx; i ++) {
      kp.put(new Long(pt(2, 3) | pt(i - 2, 2) | pt(i, 1)), good);
    }
    for (int i = 4; i <= yy; i ++) {
      kp.put(new Long(pt(3, 2) | pt(2, i - 2) | pt(1, i)), good);
    }
  }

  /**
   * Returns a bitmask that represents a filled rectangle of size (x,y).
   */
  private long pt(int x, int y) {
    return ((1L << Math.min(x, xx)) - 1L) * ymask[Math.min(y, yy)];
  }

  /**
   * Returns a bitmask that represents the big rectangle after
   * cutting out a cone.
   */
  private long maskMP(int x, int y) {
    return pt(x, yy) | pt(xx, y);
  }

  /**
   * Repaint the cone of the specified square and the message area.
   */
  private void refresh(int x, int y) {
    repaint(x * xoff + 1, y * yoff + 1, (xx - x) * xoff, (yy - y) * yoff);
    repaint(0, yy * yoff + 1, xx * xoff + 1, yoff);
  }

  public void paint(Graphics g) {
    g.setColor(Color.black);
    int i = 0;
    for (int r = 0 ; r < yy ; r++) {
      for (int c = 0 ; c < xx ; c++, i++) {
        if ((cp & (1L << i)) != 0) {
          g.drawImage(notImage, c * xoff + 1, r * yoff + 1, this);
        }
      }
    }
    for (int r = 0; r <= yy; r ++) {
      g.drawLine(0, r * yoff, xx * xoff, r * yoff);
    }
    for (int c = 0; c <= xx; c ++) {
      g.drawLine(c * xoff, 0, c * xoff, yy * yoff);
    }
    g.drawString(msg, 2, y1);
    g.drawString("Level " + level, x2, y1);
    g.setColor(darkGreen);
    g.drawString(msgEo, 2, y2);
    g.drawString("Nivelo " + level, x2, y2);
  }

  public boolean mouseUp(Event evt, int x, int y) {
    if (cp == 0) {
      // Start a new game
      cp = pt(xx, yy);
      msg = moveMsg;
      msgEo = moveMsgEo;
      repaint();
      thinking = false;
      return true;
    }
    ux = x / xoff;
    uy = y / yoff;
    new Thread(this).start();
    return true;
  }

  /**
   * The user has clicked in the applet.
   * If the user made a legal move, then respond with a move.
   */
  public void run() {
    if (thinking) {
      return;
    }
    try {
      thinking = true;
      if ((ux < 0) || (ux >= xx) || (uy < 0) || (uy >= yy)) {
        return;
      }
      long op = cp;
      cp &= maskMP(ux,uy);
      if (cp == op) {
        return;
      }
      if (cp == 0) {
        msg = "I win (you took the last square).    Click any square";
        msgEo = "Mi gajnas (vi prenis la lastan kvadraton).    Alklaku ajnan kvadraton";
        repaint();
        return;
      }
      msg = "    I am thinking ...";
      msgEo = "    Mi pensas ...";
      refresh(ux, uy);
      try {
        int slow = Math.max(3, 10 - level);
        Thread.sleep((long) (10 * count(cp) * Math.random()) +
          20 * slow * slow);
      }
      catch (InterruptedException ex) {
      }
      myMove();
      showStatus("(" + (my + 1) + "," + (mx + 1) + ")");
      if (cp == 0) {
        msg = "You win. Congratulations!    Click any square";
        msgEo = "Vi gajnas. Gratulon!    Alklaku ajnan kvadraton";
        level ++;
        setMatiKp();
      }
      else {
        msg = moveMsg;
        msgEo = moveMsgEo;
      }
      refresh(mx, my);
    }
    finally {
      thinking = false;
    }
  }

  /**
   * Computer's move.
   * @return true if successful
   */
  private boolean myMove() {
    Vector best = new Vector();
    int bv = lose.intValue();
    for (int x = 0; x < xx; x++) {
      for (int y = 0; y < yy; y++) {
        long np = cp & maskMP(x, y);
        if (np != cp) {
          // Call removeAllElementus if the new position is better.
          int value = estimate(np);
          if (value > bv) {
            bv = value;
            best.removeAllElements();
          }
          if (value == bv) {
            best.addElement(new Long(maskMP(x, y)));
          }
        }
      }
    }
    mx = my = 0;
    if (best.isEmpty()) {
      return false;
    }
    int index = (int) (Math.random() * best.size());
    long msk = ((Long) best.elementAt(index)).longValue();
    cp &= msk;
    // Evaluate mx and my
    msk = (msk + 1) & ~ msk;
    int i = -1;
    while (msk != 0) {
      msk >>>= 1;
      i ++;
    }
    mx = i % xx;
    my = i / xx;
    return true;
  }

  private int plainEstimate(long pos) {
    Long key = new Long(pos);
    if (kp.containsKey(key)) {
      return ((Integer) kp.get(key)).intValue();
    }
    return 0;
  }

  private int estimate(long pos) {
    int value = plainEstimate(pos);
    if (value != 0 || level < 3) {
      return value;
    }
    long np = pos & maskMP(1, 1);
    if (np != pos && plainEstimate(np) > 0) {
      return look.intValue(); // Simple heuristics
    }
    for (int i = 1; i < xx; i ++) {
      np = pos & maskMP(i, 0); // By Mati Pentus
      if (np != pos && plainEstimate(np) > 0) {
        return look.intValue();
      }
    }
    for (int i = 1; i < yy; i ++) {
      np = pos & maskMP(0, i);
      if (np != pos && plainEstimate(np) > 0) {
        return look.intValue();
      }
    }
    if (level < 7) {
      return value;
    }
    for (int x = 1; x < xx; x ++) {
      for (int y = 1; y < yy; y ++) {
        np = pos & maskMP(x, y);
        if (np != pos && plainEstimate(np) > 0) {
          return look.intValue();
        }
      }
    }
    return value;
  }

  /**
   * Counts 1s in the binary representmation of pos.
   */
  private int count(long pos) {
    int result = 0;
    while (pos != 0) {
      pos &= pos - 1;
      result ++;
    }
    return result;
  }

}
}
