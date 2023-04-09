import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class GenelUye
{
    private String isim;
    private String soyisim;
    private String mail;

    public GenelUye(String isim, String soyisim, String mail)
    {
        this.isim = isim;
        this.soyisim = soyisim;
        this.mail = mail;
    }

    public String getIsim()
    {
     return isim;
    }
    public String getSoyisim()
    {
        return soyisim;
    }
    public String getMail()
    {
        return mail;
    }
    public void setEmail(String mail)
    {
        this.mail = mail;
    }
    public String toString()
    {
        return isim + "\t" + soyisim + "\t" + mail;

    }
}
class ElitUye extends GenelUye
{
    public ElitUye(String isim, String soyisim, String mail)
    {
        super(isim, soyisim, mail);
    }
}
public class Main
{
    private static final String filepath = "C:/Users/SERPİL/IdeaProjects/JavaOPP/Kullanıcılar.txt";
    private static ArrayList<ElitUye> ElitUyeler = new ArrayList<ElitUye>();
    private static ArrayList<GenelUye> GenelUyeler = new ArrayList<GenelUye>();

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/SERPİL/IdeaProjects/JavaOPP/Kullanıcılar.txt");
        File dosyam = new File("C:/Users/SERPİL/IdeaProjects/JavaOPP/Kullanıcılar.txt");
        if (!dosyam.createNewFile()) {
            System.out.println("Dosya zaten bulunmakta. ");
        } else {
            System.out.println("Dosya başarıyla oluşturuldu. " + dosyam.getName());
        }

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Menü");
            System.out.println("1- Elit üye ekleme");
            System.out.println("2- Genel Üye ekleme");
            System.out.println("3- Mail Gönderme");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            switch (secim)
            {
                case 1:
                    System.out.println("İsim: ");
                    String ElitIsim = scanner.next();
                    System.out.println("Soyisim: ");
                    String ElitSoyisim = scanner.next();
                    System.out.println("Mail: ");
                    String ElitMail = scanner.next();

                    ElitUye elitUye = new ElitUye(ElitIsim,ElitSoyisim,ElitMail);
                    ElitUyeler.add(elitUye);
                    try
                    {
                       FileWriter filewriter = new FileWriter("Kullanıcılar.txt",true);
                        PrintWriter printWriter = new PrintWriter(filewriter);
                        printWriter.printf("%s\t%s\t%s%n", elitUye.getIsim(), elitUye.getSoyisim(), elitUye.getMail());
                        printWriter.close();
                        System.out.println("Elit üye kaydedildi. ");

                    } catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Dosyaya yazma hatası. ");
                    break;

                case 2:
                    System.out.println("İsim: ");
                    String GenelIsim = scanner.next();
                    System.out.println("Soyisim: ");
                    String GenelSoyisim = scanner.next();
                    System.out.println("Mail: ");
                    String GenelMail = scanner.next();

                    GenelUye genelUye = new GenelUye(GenelIsim,GenelSoyisim,GenelMail);
                    GenelUyeler.add(genelUye);
                    try
                    {
                        FileWriter fileWriter = new FileWriter("Kullanıcılar.txt", true);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.printf("%s\t%s\t%s%n", genelUye.getIsim(), genelUye.getSoyisim(), genelUye.getMail());
                        printWriter.close();
                        System.out.println("Genel üye kaydedildi. ");
                    }catch(IOException e)
                    {
                        System.out.println("Dosyayı yazarken hata oluştu. ");
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    System.out.println("1- Elit üyelere mail yollamak");
                    System.out.println("2- Genel üyelere mail yollamak");
                    System.out.println("3- Tüm üyelere mail yollamak ");
                    int mailSecim = scanner.nextInt();
                    scanner.nextLine();
                    switch (mailSecim)
                    {
                        case 1:
                            System.out.println("Elit üyelere göndermek istediğiniz mesaj içeriğini giriniz: ");
                            String elitIcerik = scanner.nextLine();
                            System.out.println("Mesaj gönderildi: ");
                            break;
                        case 2:
                            System.out.println("Genel üyelere göndermek istediğiniz mesaj içeriğini  giriniz: ");
                            String genelIcerik = scanner.nextLine();
                            System.out.println("Mesaj gönderildi: ");
                            break;
                        case 3:
                            System.out.println("Tüm üyelere gönderilecek mesajı içeriğini giriniz");
                            String tumIcerik = scanner.nextLine();
                            System.out.println("Mesaj herkese gönderildi");
                            break;

                        default:
                            System.out.printf("Geçersiz seçim. ");
                            break;


                    }
                default:
                    System.out.println("Geçersiz seçim. ");





            }







        }



    }
}


