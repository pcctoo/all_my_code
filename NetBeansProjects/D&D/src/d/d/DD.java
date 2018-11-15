/*
this is a random genorator for monsters and on dungions and dragons 5.0 and a encounter roller...
 */

package d.d;


public class DD {
    /*in this code we will first make a array list of creatures, then a list of trap scinarios, then a list of
    happenings(things that will happen, basicly a small genarator that gives you small storys starts.)
    i am going to make a go between that will chose a creture based on cadigory.
    it will be like if i want a lower level creture i dont want a turask poping up.
    i will do it by making sections of the array and the number genarators will have options between the areas that i decide
    like for instance random all will be between 0-153(i dont know at this point how high it will go.)
    and lower lvl will be like 153-200. and so on and so forth.
    once the arrays are done we will make methods to run a random genarator and pull the number out of the array list. 
    
    once that is compleat i will habe a graphics window that will give buttons that you can press to actavate it. this will have to be a 
    user frindly gui, i will not ship with out a clean user interface. let the long hours of coading begin...
    */
public String creature;
public String trap;
//creature and trap is decided by the user. wether they want this to be a full incounter or just a inconvinence like a rock falling or somthiing.
public String happens;
//happens is the circumstances surounding the encounter. 
    public static void main(String[] args) {
    //this is the array that i keep all the creatures in.
    //the url for the list is https://en.wikipedia.org/wiki/List_of_Dungeons_%26_Dragons_5th_edition_monsters#A92180000_-_Monster_Manual_(2014)
    // creature[] = "";
    String [] creature = new String [250];
creature[0] = "Aarkocra pg12";
creature[1] = "aboleth pg13";
creature[2] = "angels pg15";
creature[3] = "animated objects pg19";
creature[4] = "ankheg pg21";
creature[5] = "azer pg22";
creature[6] = "banshee pg23";  
creature[7] = "basilisk pg24";
creature[8] = "behir pg25";
creature[9] = "pick a beholder pg26-pg30";
creature[10] = "blights pg31";
creature[11] = "bugbeaars pg33";
creature[12] = "bulette pg34";
creature[13] = "bullywug pg35";
creature[14] = "cambion pg36";
creature[15] = "carrion crawler pg37";
creature[16] = "cenraur pg38";
creature[17] = "chimera pg39";
creature[18] = "chuul pg40";
creature[19] = "cloaker pg41";
creature[20] = "cockatrice pg42";
creature[21] = "couatl pg43";
creature[22] = "crawling claw pg44";
creature[23] = "cyclops pg45";
creature[24] = "darkmantle pg46";
creature[25] = "dark knight pg47";
creature[26] = "demilich pg48";
creature[27] = "demons pg50-pg65";
creature[28] = "devils pg66-pg78";
creature[29] = "dinosaurs pg79-pg80";
creature[30] = "displacer beast pg81";
creature[31] = "doppelganger pg82";
creature[32] = "dracolich pg83-pg84";
creature[33] = "shadow, dragon pg84-pg85";
creature[34] = "dragons pg86-pg118";
creature[35] = "dragon turtle pg119";
creature[36] = "drider pg120";
creature[37] = "dryad pg121";
creature[38] = "duergar pg122";
creature[39] = "elementals pg123-pg125";
creature[40] = "drow pg126-pg129";
creature[41] = "empyrean pg130";
creature[42] = "ettercap pg131";
creature[43] = "ettin pg132";
creature[44] = "faerie dragon pg133";
creature[45] = "flameskull pg134";
creature[46] = "flumph pg135";
creature[47] = "fomorian pg136";
creature[48] = "fungi pg137-pg138";
creature[49] = "galeb duhr pg139";
creature[50] = "gargoyle pg140";
creature[51] = "genies pg141-146";
creature[52] = "ghost pg147";
creature[54] = "ghouls pg148";
creature[55] = "giants pg149-pg156";
creature[56] = "gibbering mouther pg157";
creature[57] = "giths pg158-pg161";
creature[58] = "gnolls pg162-pg163";
creature[59] = "deep gnome pg164";
creature[60] = "goblins pg165-pg166";
creature[61] = "golems pg167-pg170";
creature[62] = "gorgon pg171";
creature[63] = "grell pg172";
creature[64] = "grick pg173";
creature[65] = "griffon pg174";
creature[66] = "grimlock pg175";
creature[67] = "hags pg176-pg179";
creature[68] = "half-dragon pg180";
creature[69] = "harpy pg181";
creature[70] = "hell hound pg182";
creature[71] = "helmed horror pg183";
creature[72] = "hippogriff pg184";
creature[73] = "hobgoblin pg15-pg187";
creature[74] = "homunculus pg188";
creature[75] = "hook horror pg189";
creature[76] = "hydra pg190";
creature[77] = "Intellect Devourer pg191";
creature[78] = "invisable stalkers pg192";
creature[79] = "jackelwere pg193";
creature[80] = "kenku pg194";
creature[81] = "kobald pg195";
creature[82] = "kraken pg 196-pg197";
creature[83] = "kuo-toa pg198-pg200";
creature[84] = "lamia pg201";
creature[85] = "lich pg202-pg203";
creature[86] = "lizardfolk pg204-pg204";
creature[87] = "lycanthropes pg206-pg211";
creature[88] = "magmin pg212";
creature[89] = "manticore pg213";
creature[90] = "medusa pg214";
creature[91] = "mephits pg215-pg217";
creature[92] = "merfolk pg218";
creature[93] = "merrow pg219";
creature[94] = "mimic pg220";
creature[95] = "minf=d flyer pg221-pg222";
creature[96] = "minotaur pg223";
creature[97] = "modrons pg224-pg226";
creature[98] = "mummies pg227-pg229";
creature[99] = "myconids pg230-pg232";
creature[100] = "nagas pg233-pg234";
creature[101] = "nightmere pg235";
creature[102] = "nothic pg236";
creature[103] = "ogre pg237-pg238";
creature[104] = "oni pg239";
creature[105] = "ooze pg240-pg243";
creature[106] = "orcs pg244-pg247";
creature[107] = "otyugh pg248";
creature[108] = "owlbear pg249";
creature[109] = "pegasus pg250";
creature[110] = "peryton pg251";
creature[111] = "piercer pg252";
creature[112] = "pixie pg253";
creature[113] = "pseudodragon pg254";
creature[114] = "purple worm pg255";
creature[115] = "quaggoth pg256";
creature[116] = "rakshasa pg257";
creature[117] = "remorhaz pg258";
creature[118] = "revenant pg259";
creature[119] = "roc pg260";
creature[120] = "roper pg261";
creature[121] = "rust monster pg262";
creature[122] = "shugin pg263-pg264";
creature[123] = "salamanders pg265-pg266";
creature[124] = "satyr pg267";
creature[125] = "scarecrow pg268";
creature[126] = "shadow pg269";
creature[127] = "shambling mound pg270";
creature[128] = "shield guardian pg271";
creature[129] = "skeletons pg272-pg273";
creature[130] = "slaadi pg274-pg278";
creature[131] = "specter pg279";
creature[132] = "sphinxes pg280-pg282";
creature[134] = "sprite pg283";
creature[135] = "stirge pg284";
creature[136] = "succubus and incubus pg284-pg285";
creature[137] = "tarrasque pg286-pg287";
creature[138] = "treant pg289";
creature[139] = "troglodyte pg290";
creature[140] = "troll pg291";
creature[141] = "umber hulk pg292";
creature[142] = "unicorn pg293-pg294";
creature[143] = "vampires pg295-pg298";
creature[144] = "water weird pg299";
creature[145] = "wight pg300";
creature[146] = "will-0-wasp pg301";
creature[147] = "wraith pg302";
creature[148] = "wyvern pg303";
creature[149] = "xorn pg304";
creature[150] = "yeti pg305-pg306";
creature[151] = "yuan-ti pg307-pg310";
creature[152] = "yugoloths pg311-pg314";
creature[153] = "zombies pg315-pg216";
creature[154] = "";
creature[155] = "";
creature[156] = "";
creature[157] = "";
creature[158] = "";
creature[159] = "";
creature[160] = "";
creature[161] = "";
creature[162] = "";
creature[163] = "";
creature[164] = "";
creature[165] = "";
creature[166] = "";
creature[167] = "";
creature[168] = "";
creature[169] = "";
creature[170] = "";
creature[171] = "";
creature[172] = "";
creature[173] = "";
creature[174] = "";
creature[175] = "";
creature[176] = "";
creature[177] = "";
creature[178] = "";
creature[179] = "";
creature[180] = "";
creature[181] = "";
creature[182] = "";
creature[183] = "";
creature[184] = "";
creature[185] = "";
creature[186] = "";
creature[187] = "";
creature[189] = "";
creature[190] = "";
creature[191] = "";
creature[192] = "";
creature[193] = "";
creature[194] = "";
creature[195] = "";
creature[196] = "";
creature[197] = "";
creature[198] = "";
creature[199] = "";
creature[200] = "";
    }
/*
    first i will build a array. 
    then i will make a jpannal with 6 buttions. one will be all the array. the next will be the weaker monsters the next will be the harder monsters. 
    then it will be the scinario buttions. that will tie to anouther array. then it will be a random animal button. 
    b1=all monsters
    b2= all lower lvl monsters
    b2= all higher monsters
    b4= boss lower
    b5= boss higher
    b6= scinarieo
    the top of the sreen will have a print out for the output. 
    and a clear buttion under the output. 
    
    */
    
}
