package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringSet {

    public static List<String> findUniqueWords() {

        // Örnek metnimizi bir String değişkenine atıyoruz
        String text = "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. "
                + "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, "
                + "and in November he began working on the manuscript in earnest. To add the finishing touches he researched "
                + "natural history in connection with the animals presented in the book and then had the book examined "
                + "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations "
                + "to the original copy, on publication he was advised to find a professional illustrator so the pictures "
                + "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret "
                + "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the"
                + " children.\n"
                + "\n"
                + "Carroll began planning a print edition of the Alice story in 1863. "
                + "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice."
                + " A diary entry for 2 July says that he received a specimen page of the print edition around that date. "
                + "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations "
                + "by Carroll, dedicating it as \"A Christmas Gift to a Dear Child in Memory of a Summer's Day\"."
                + " The published version of Alice's Adventures in Wonderland is about twice the length of "
                + "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, "
                + "that did not appear in the manuscript. The only known manuscript copy of Under Ground "
                + "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

        // Noktalama işaretlerini temizleyelim (. , ! ? ")
        // Dikkat: Replace işlemini tek tek ya da toplu şekilde Regex ile yapabiliriz.
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");  // Sadece harf, sayı ve boşlukları bırak

        // Unicode karakterleri de temizle
        text = text.replaceAll("[^\\p{L}\\p{Nd}\\s]", "");  // Harf ve sayıları bırak, diğer her şeyi kaldır

        // Tüm sayıları metinden çıkartalım
        text = text.replaceAll("\\d+", "");

        // Tüm karakterleri küçük harfe çevirelim (unique işleminde faydalı olur)
        text = text.toLowerCase();

        // Tüm boşluk karakterlerine ek olarak çizgi, tire, alt tire gibi karakterleri de ayırıcı kabul et
        String[] words = text.split("[\\s\\-]+");

        // Tekrarlanmayan kelimeleri saklamak için TreeSet (alfabetik sıralama özelliği var)
        Set<String> uniqueWords = new TreeSet<>();

        // Dizi içindeki kelimeleri set'e ekleyelim
        for (String word : words) {
            // Boş veya kontrol karakteri gelmesini engellemek için trim de yapabiliriz
            word = word.trim();
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }

        // Artık uniqueWords içerisinde tekrar etmeyen ve alfabetik sıralı kelimeler var
        // List olarak döndürmek istersek:
        return new ArrayList<>(uniqueWords);
    }
}