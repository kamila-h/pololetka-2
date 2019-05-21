package cz.alisma.alej.text.templater;

import java.util.Map;
import java.util.List;

public class ZarovnaniDoRadku {
	
	public static String fill(List<String> vzor, Map <String, String> uplnyVysledek) {
		
        StringBuilder novaRadka = new StringBuilder();

        for(String str : vzor) {
            StringBuilder radka = new StringBuilder(str);
            
            for (int zacatek = radka.indexOf("{{"); zacatek != -1; zacatek = radka.indexOf("{{", zacatek + 5)) {
            	int konec = radka.indexOf("}}", zacatek) + 2;
                String vysledek = radka.substring(zacatek + 3, konec - 3);
                radka.replace(zacatek, konec, uplnyVysledek.get(vysledek));
            	}
            novaRadka.append(radka);
            novaRadka.append("\n");
        }
        return novaRadka.toString();
    }

}
