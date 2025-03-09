import java.util.Scanner;

public class SistemLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Sistem Login ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            String nimTerakhir = "181";
            String validUsername = "Admin" + nimTerakhir;
            String validPassword = "password" + nimTerakhir;

            if (username.equals(validUsername) && password.equals(validPassword)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            String validNama = "Danishwara";
            String validNim = "202410370110181";

            if (nama.equals(validNama) && nim.equals(validNim)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM anda salah.");
            }
        } else {
            System.out.println("Pilihan (tidak valid.");
        }

        scanner.close();
    }
}