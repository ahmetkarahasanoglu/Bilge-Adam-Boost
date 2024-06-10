# --- IMAGE DOSYASI OLUŞTURMAK İÇİN GEREKLİ KODLAR: ---
# İlk olarak kullanılacak jdk sistemi ve türü seçilir. Jdk versiyonu
# olarak build.gradle dosyasında yazan [sourceCompatibility = '17']
# ibaresindeki versiyon numarası kullanılır.
FROM amazoncorretto:17
# oluşturulacak imajın içine çalıştıracağınız jar dosyasının
# kopyalanması: handi dosyayı kopyalayacağımızı yazarız, ve nereye
# hangi adla kopyalanacağını yazarız: Ornek 1:
# COPY build/libs/Monolitik-0.0.1-SNAPSHOT.jar app.jar

# Ayrıca, tek dosya üzerinden (Dockerfile) farklı projeleri import
# etmek için Argüman kullanarak işlem yapabilirsiniz:
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Eğer güncelleme yapmak isterseniz aşağıdaki update komutu
# yazılabilir:( burdaki '-y' evet/hayır sorusuna 'evet' cevabı
# ver demektir.
CMD apt-get update -y

# Jar dosyası, çalışması için tetiklenir. Java'yı kullanarak
# jar dosyası olan app.jar'ı çalıştır diyoruz:
ENTRYPOINT ["java","-jar","/app.jar"]