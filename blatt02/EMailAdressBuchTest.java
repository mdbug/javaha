import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class EMailAdressBuchTest {

    public static void main(String[] args) {
        EMailAdressBuch emails = new EMailAdressBuch();
        try {
            emails.einlesen("emailadressbuch.txt");
            System.out.println(emails);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        EMailAdressBuch matseEmails = new EMailAdressBuch();
        try {
            //FIXME
            URL urlIntern = new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt");
            URL urlExtern = new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_extern.txt");
            matseEmails.mitarbeiterEinlesen(urlIntern);
            matseEmails.mitarbeiterEinlesen(urlExtern);
            System.out.println(matseEmails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
