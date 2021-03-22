public class Main {
    public static void main(String[] args) {
        String choose ;
        boolean exit = false;
        ManageContacts manageContacts = new ManageContacts();
        showMenu();
        while (true){
            choose = new Input().inputString();
            switch (choose){
                case "1":
                    manageContacts.displayContacts();
                    break;
                case "2":
                    manageContacts.addContacts();
                    break;
                case "3":
                    manageContacts.edit();
                    break;
                case "4":
                    manageContacts.deleteContact();
                    break;
                case "5":
                    manageContacts.displayByPhoneNumber();
                    break;


                case "6":
                    manageContacts.read();
                    break;
                case "7":
                    manageContacts.write();
                    break;
                case "8":
                    System.out.println("Thoat!");
                    exit = true;
                default:
                    System.out.println("Khong dung nhap lai");
                    break;
            }
            if(exit){
                break;
            }
            showMenu();
        }
    }
    public static void showMenu(){
            System.out.println("---Chương Trình Quản Lý Danh Bạ---");
            System.out.println("Chọn chức năng theo số");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7  Ghi vào ");
            System.out.println("8. Thoát");
            System.out.println("Chọn Chức Năng");
        }
        public static  void showMenu2(){
            System.out.println("1.Tim theo ten");
            System.out.println("2.Tim theo so dien thoai");
        }
    }

