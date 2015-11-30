package com.skula.school.models;

import com.skula.school.services.DatabaseService;

public class Data {
	public static void insert(DatabaseService dbs){
		//---- temps ------
		dbs.insertCategory("Adv. de temps", "allemand");
		dbs.insertWord("bald", "bient�t", "1");
		dbs.insertWord("bereits", "d�j�", "1");
		dbs.insertWord("bisher", "jusqu'� pr�sent", "1");
		dbs.insertWord("danach", "apr�s", "1");
		dbs.insertWord("davor", "avant", "1");
		dbs.insertWord("einst", "jadis", "1");
		dbs.insertWord("endlich", "enfin, � la fin", "1");
		dbs.insertWord("freitags", "le vendredi", "1");
		dbs.insertWord("gestern", "hier", "1");
		dbs.insertWord("immer", "toujours", "1");
		dbs.insertWord("inzwischen", "entre-temps", "1");
		dbs.insertWord("neulich", "r�cemment", "1");
		dbs.insertWord("nie", "jamais", "1");
		dbs.insertWord("oft", "souvent", "1");
		dbs.insertWord("regelm�$ig", "r�guli�rement", "1");
		dbs.insertWord("sofort", "tout de suite", "1");
		dbs.insertWord("stets", "constamment", "1");
		dbs.insertWord("t�glich", "quotidiennement", "1");
		dbs.insertWord("zurzeit", "actuellement", "1");

		//----- lieu -----
		dbs.insertCategory("Adv. de lieu", "allemand");
		dbs.insertWord("aufw�rts", "vers le haut", "2");
		dbs.insertWord("au$en", "� l'ext�rieur", "2");
		dbs.insertWord("da", "l�", "2");
		dbs.insertWord("dort", "l�-bas", "2");
		dbs.insertWord("drinnen", "� l'int�rieur", "2");
		dbs.insertWord("fort", "au loin", "2");
		dbs.insertWord("hier", "ici", "2");
		dbs.insertWord("hierhin", "(vers/jusqu'�) ici", "2");
		dbs.insertWord("hinein", "�l'int�rieur", "2");
		dbs.insertWord("hinten", "derri�re", "2");
		dbs.insertWord("irgendwo", "quelque part", "2");
		dbs.insertWord("links", "� gauche", "2");
		dbs.insertWord("nebenan", "� c�t�", "2");
		dbs.insertWord("oberhalb", "au-dessus", "2");
		dbs.insertWord("�berall", "partout", "2");
		dbs.insertWord("unten", "au-dessous", "2");
		dbs.insertWord("vorn", "devant", "2");

		//----- cause ------
		dbs.insertCategory("Adv. de cause", "allemand");
		dbs.insertWord("also", "ainsi, donc", "3");
		dbs.insertWord("anstandshalber", "par souci des convenances", "3");
		dbs.insertWord("dadurch", "par ce moyen", "3");
		dbs.insertWord("darum", "c'est pourquoi", "3");
		dbs.insertWord("demnach", "en cons�quence", "3");
		dbs.insertWord("demzufolge", "par cons�quent", "3");
		dbs.insertWord("deshalb", "pour cette raison, pour cela", "3");
		dbs.insertWord("folglich", "par cons�quent", "3");
		dbs.insertWord("somit", "par cons�quent", "3");

		//----- coordination -----
		dbs.insertCategory("Adv. de coordination", "allemand");
		dbs.insertWord("au$erdem", "en outre", "4");
		dbs.insertWord("danach", "ensuite", "4");
		dbs.insertWord("deshalb", "pour cette raison, c'est pourquoi", "4");
		dbs.insertWord("folglich", "par conséquent", "4");
		dbs.insertWord("schlie$lich", "finalement, apr�s tout", "4");
		dbs.insertWord("trotzdem", "malgr� tout", "4");
		dbs.insertWord("zuvor", "auparavant, avant", "4");

		//----- maniere ------
		dbs.insertCategory("Adv. de maniere", "allemand");
		dbs.insertWord("anders", "autrement", "5");
		dbs.insertWord("�u$erst", "extr�mement", "5");
		dbs.insertWord("beinahe", "presque, quasi", "5");
		dbs.insertWord("bekanntlich", "comme chacun sait", "5");
		dbs.insertWord("ebenfalls", "aussi", "5");
		dbs.insertWord("fast", "presque", "5");
		dbs.insertWord("folgenderma$en", "de la mani�re suivante", "5");
		dbs.insertWord("ganz", "tout, enti�rement", "5");
		dbs.insertWord("genauso", "de m�me", "5");
		dbs.insertWord("genug", "assez", "5");
		dbs.insertWord("gern", "volontiers", "5");
		dbs.insertWord("gr�$tenteils", "en majeure partie, majoritairement", "5");
		dbs.insertWord("haupts�chlich", "surtout", "5");
		dbs.insertWord("kaum", "gu�re, � peine", "5");
		dbs.insertWord("leider", "malheureusement", "5");
		dbs.insertWord("m�glicherweise", "peut-�tre", "5");
		dbs.insertWord("reihenweise", "les uns apr�s les autres", "5");
		dbs.insertWord("sehr", "tr�s", "5");
		dbs.insertWord("so", "ainsi", "5");
		dbs.insertWord("vielleicht", "peut-�tre", "5");
		dbs.insertWord("wirklich", "vraiment", "5");
	}
}
