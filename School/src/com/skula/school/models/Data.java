package com.skula.school.models;

import com.skula.school.services.DatabaseService;

public class Data {
	public static void insert(DatabaseService dbs){
		//---- temps ------
		dbs.insertCategory("Adv. de temps", "allemand");
		dbs.insertWord("bald", "bientôt", "1");
		dbs.insertWord("bereits", "déjà", "1");
		dbs.insertWord("bisher", "jusqu'à  présent", "1");
		dbs.insertWord("danach", "après", "1");
		dbs.insertWord("davor", "avant", "1");
		dbs.insertWord("einst", "jadis", "1");
		dbs.insertWord("endlich", "enfin, à la fin", "1");
		dbs.insertWord("freitags", "le vendredi", "1");
		dbs.insertWord("gestern", "hier", "1");
		dbs.insertWord("immer", "toujours", "1");
		dbs.insertWord("inzwischen", "entre-temps", "1");
		dbs.insertWord("neulich", "récemment", "1");
		dbs.insertWord("nie", "jamais", "1");
		dbs.insertWord("oft", "souvent", "1");
		dbs.insertWord("regelmä$ig", "régulièrement", "1");
		dbs.insertWord("sofort", "tout de suite", "1");
		dbs.insertWord("stets", "constamment", "1");
		dbs.insertWord("täglich", "quotidiennement", "1");
		dbs.insertWord("zurzeit", "actuellement", "1");

		//----- lieu -----
		dbs.insertCategory("Adv. de lieu", "allemand");
		dbs.insertWord("aufwärts", "vers le haut", "2");
		dbs.insertWord("au$en", "à  l'extérieur", "2");
		dbs.insertWord("da", "là", "2");
		dbs.insertWord("dort", "là-bas", "2");
		dbs.insertWord("drinnen", "à  l'intérieur", "2");
		dbs.insertWord("fort", "au loin", "2");
		dbs.insertWord("hier", "ici", "2");
		dbs.insertWord("hierhin", "(vers/jusqu'à) ici", "2");
		dbs.insertWord("hinein", "à l'intérieur", "2");
		dbs.insertWord("hinten", "derrière", "2");
		dbs.insertWord("irgendwo", "quelque part", "2");
		dbs.insertWord("links", "à gauche", "2");
		dbs.insertWord("nebenan", "à côté", "2");
		dbs.insertWord("oberhalb", "au-dessus", "2");
		dbs.insertWord("überall", "partout", "2");
		dbs.insertWord("unten", "au-dessous", "2");
		dbs.insertWord("vorn", "devant", "2");

		//----- cause ------
		dbs.insertCategory("Adv. de cause", "allemand");
		dbs.insertWord("also", "ainsi, donc", "3");
		dbs.insertWord("anstandshalber", "par souci des convenances", "3");
		dbs.insertWord("dadurch", "par ce moyen", "3");
		dbs.insertWord("darum", "c'est pourquoi", "3");
		dbs.insertWord("demnach", "en conséquence", "3");
		dbs.insertWord("demzufolge", "par conséquent", "3");
		dbs.insertWord("deshalb", "pour cette raison, pour cela", "3");
		dbs.insertWord("folglich", "par conséquent", "3");
		dbs.insertWord("somit", "par conséquent", "3");

		//----- coordination -----
		dbs.insertCategory("Adv. de coordination", "allemand");
		dbs.insertWord("au$erdem", "en outre", "4");
		dbs.insertWord("danach", "ensuite", "4");
		dbs.insertWord("deshalb", "pour cette raison, c'est pourquoi", "4");
		dbs.insertWord("folglich", "par consÃ©quent", "4");
		dbs.insertWord("schlie$lich", "finalement, après tout", "4");
		dbs.insertWord("trotzdem", "malgré tout", "4");
		dbs.insertWord("zuvor", "auparavant, avant", "4");

		//----- maniere ------
		dbs.insertCategory("Adv. de maniere", "allemand");
		dbs.insertWord("anders", "autrement", "5");
		dbs.insertWord("äu$erst", "extrêmement", "5");
		dbs.insertWord("beinahe", "presque, quasi", "5");
		dbs.insertWord("bekanntlich", "comme chacun sait", "5");
		dbs.insertWord("ebenfalls", "aussi", "5");
		dbs.insertWord("fast", "presque", "5");
		dbs.insertWord("folgenderma$en", "de la manière suivante", "5");
		dbs.insertWord("ganz", "tout, entièrement", "5");
		dbs.insertWord("genauso", "de même", "5");
		dbs.insertWord("genug", "assez", "5");
		dbs.insertWord("gern", "volontiers", "5");
		dbs.insertWord("grö$tenteils", "en majeure partie, majoritairement", "5");
		dbs.insertWord("hauptsächlich", "surtout", "5");
		dbs.insertWord("kaum", "guère, à  peine", "5");
		dbs.insertWord("leider", "malheureusement", "5");
		dbs.insertWord("möglicherweise", "peut-être", "5");
		dbs.insertWord("reihenweise", "les uns après les autres", "5");
		dbs.insertWord("sehr", "très", "5");
		dbs.insertWord("so", "ainsi", "5");
		dbs.insertWord("vielleicht", "peut-être", "5");
		dbs.insertWord("wirklich", "vraiment", "5");
	}
}
