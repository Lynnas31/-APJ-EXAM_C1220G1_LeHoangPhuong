import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageContacts {


    static List<Contacts> contactsList = new ArrayList<>();
    static Contacts contacts3 = new Contacts(123456,"Gia dinh","Nguyen van A","Nam","Hanoi","ngvanA@gmail.com");
    static Contacts contacts4 =  new Contacts(234567,"Ban be ","Nguyen Van B","Nam","Saigon","ngvanB@gmail.com");
    static {
        contactsList.add(contacts3);
        contactsList.add(contacts4);
    }
    public void addContacts() {
        System.out.println("Nhập số điện thoại");
        long number = new Input().inputNumber();
        if (checkByPhoneNumber(number)) {
            System.out.println("Danh bạ đã tồn tại");
        } else {
            System.out.println("Nhap Nhom ");
            String group = new Input().inputString();
            System.out.println("Nhap Ten");
            String name = new Input().inputString();
            System.out.println("Nhap Gioi Tinh");
            String gender = new Input().inputString();
            System.out.println("Nhap Dia Chi");
            String address = new Input().inputString();
            System.out.println("Nhap Email");
            String email = new Input().inputString();
            contactsList.add(new Contacts(number, group, name, gender, address, email));

            System.out.println("Da them thanh cong");
        }
    }

    public void edit() {
        System.out.println("Nhap so dien thoai can sua");
        long number = new Input().inputNumber();
        Contacts editContacts = findByPhoneNumber(number);
        System.out.println("Nhap nhom moi");
        editContacts.setGroup(new Input().inputString());
        System.out.println("Nhap ten moi ");
        editContacts.setName(new Input().inputString());
        System.out.println("Nhap gioi tinh");
        editContacts.setGender(new Input().inputString());
        System.out.println("Nhap dia chi moi");
        editContacts.setAddress(new Input().inputString());
        System.out.println("Nhap Email moi");
        editContacts.setEmail(new Input().inputString());

    }

    public void deleteContact() {
        System.out.println("Nhap so dien thoai can xoa");
        long number = new Input().inputNumber();
        Contacts deleteContacts = null;
        if (!checkByPhoneNumber(number)) {
            System.out.println("So dien thoai khong dung, nhap lai");
        } else {
            for (Contacts contacts : contactsList
            ) {
                if (contacts.getPhoneNumber() == number) {
                    deleteContacts = contacts;
                }
            }
        }
        System.out.println("Dong Y Xoa");
        String confirm = new Input().inputString();
        if (confirm.equals("Y")) {
            contactsList.remove(deleteContacts);

            System.out.println("Da xoa thanh cong");
        }
    }

    public void displayByName() {
        System.out.println("Nhap ten muon tim kiem");
        String findName = new Input().inputString();
        for (Contacts contacts : contactsList
        ) {
            if (contacts.getName().equals(findName)) {
                System.out.println(contacts.toString());
            } else {
                System.out.println("Ten can tim khong co trong danh ba");
            }
        }
    }

    public void displayByPhoneNumber() {
        System.out.println("Nhap so dien thoai muon tim kiem");
        long findPhoneNumber = new Input().inputNumber();
        if(checkByPhoneNumber(findPhoneNumber)){
            for (Contacts contacts:contactsList) {
                if(contacts.getPhoneNumber()== findPhoneNumber){
                    System.out.println(contacts.toString());
                }
            }
        }
        else {
            System.out.println("So dien thoai khong dung");
        }
    }

    public boolean checkByPhoneNumber(long number) {
        for (Contacts contact : contactsList
        ) {
            if (contact.getPhoneNumber() == number) {
                return true;
            }
        }
        return false;
    }

    public Contacts findByPhoneNumber(long number) {
        Contacts contacts1 = null;
        if (!checkByPhoneNumber(number)) {
            System.out.println("So dien thoai khong dung");
        } else {

            for (Contacts contacts : contactsList
            ) {
                if (contacts.getPhoneNumber() == number) {
                    contacts1 = contacts;
                }
            }
        }
        return contacts1;
    }

    public List<Contacts> read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("data/contacts.txt");
            ois = new ObjectInputStream(fis);
            contactsList = (List<Contacts>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return contactsList;

    }
    public  void write (){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("data/contacts.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(contactsList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void displayContacts(){
        System.out.println(contactsList.toString());
    }
}