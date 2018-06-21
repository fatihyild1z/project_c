package com.yildizsoft.fatih.br

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tarihikisiler.*

class tarihikisiler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarihikisiler)
        var string="Çerkez Ethem (d. 1886, Bandırma - ö. 21 Eylül 1948, Amman), Çerkes asıllı Türk asker. Türk Kurtuluş Savaşı'nda Kuva-yi Milliye birliklerinde komutandır.\n" +
                "\n" +
                "Bandırma'nın bir köyü olan Emreköy'e yerleşmiş Şapsığ Çerkes boyundan, Ali Bey'in beş oğlunun en küçüğüydü. Ağabeyleri, İlyas ve Nuri beyler, Rum eşkıyalarıyla çarpışırken ölmüşler, Reşit ve Tevfik beyler de 1901 ve 1902 yıllarında Harbiye'yi bitirerek subay çıkmışlardı. Reşit Bey çeşitli cephelerde çarpıştı, Son Osmanlı Meclis-i Mebusan'ına Saruhan (şimdiki Manisa) Mebuslu olarak katıldı, oradan Birinci TBMM'ye geçti.\n" +
                "\n" +
                "Çerkes Ethem, evden kaçarak Bakırköy Süvari Küçük Zabit Mektebi'ne girdi. Balkan Savaşı'nda Bulgar cephesinde yaralandı. Kıdem zammı ve madalya aldı. I. Dünya Savaşı'nda Kuşçubaşı Eşref'in yönettiği Teşkilat-ı Mahsusa ile birlikte İran, Afganistan ve Irak'a yapılan akınlara katıldı. Yaralanarak savaş sonunda köyüne çekildi.\n" +
                "\n" +
                "15 Mayıs 1919 tarihinde İzmir'in işgali üzerine, vatan savunmasına başlamak için vurucu güç olarak Kuva-yi Seyyare'yi kurdu ve \"Umum Kuva-yi Milliye Komutanı\" ve Ankara'daki 20. Kolordu Komutanı olan Ali Fuat Paşa ile istişare ederek İngiliz ve Yunan birliklerinin ilerlemesine karşı gerilla operasyonları düzenledi.\n" +
                "\n" +
                "Düzenli ordu kurulana dek TBMM'ye karşı girişilen ayaklanmaları bastırdı. Anzavur Ayaklanması, Çopur Musa Ayaklanması ile Gerede ve Yozgat isyanlarını bastıran Çerkes Ethem'in isyancıları yargılamadan derhal infaz etmesi TBMM üyeleri ve İstiklal Mahkemeleri tarafından onaylanmıyordu.\n" +
                "\n" +
                "1920 yılının sonunda 20. Kolordu ve Komutanı Ali Fuat Paşa ile birlikte Gediz Muharebeleri'ne katıldı ve TBMM kuvvetleri, Gediz'i geri alarak, İzmir'in İşgali'nden sonra ilk defa Yunanların işgal ettikleri bir bölgeden geri çekilmelerini sağladı.\n" +
                "\n" +
                "Gediz Muharebeleri'nden sonra komuta kademesiyle yaşadığı anlaşmazlıklar ve düzenli ordu birliklerine katılmak istememesi yüzünden isyan etti.[1] Ocak 1921'de İsmet Bey ve Refet Bey öncülüğündeki birliklerce Çerkes Ethem birliklerine harekat düzenlendi.[2] Büyük bir çarpışma yaşanmadan, Çerkes Ethem'in birlikleri teslim oldu.[2] Kardeşleri ve küçük bir grup yandaşı ile Yunanistan'a sığınmak zorunda kaldı.[3] Yüzellilikler ismiyle anılan ve ülkeye girmesi yasaklanan kişilerden oluşan listede yer aldı.[4] Savaştan sonra Ürdün'e geçti ve 21 Eylül 1948 tarihinde Amman'da vefat etti."
        textEthem.text=string
    }
}
