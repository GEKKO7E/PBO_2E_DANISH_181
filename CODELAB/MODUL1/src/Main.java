import java.util.Scanner;
import java.time.LocalDate;

class UserData {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Meminta input dari pengguna
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char jenisKelamin = scanner.next().charAt(0);

        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = scanner.nextInt();

        // Menutup Scanner
        scanner.close();

        // Mendapatkan tahun saat ini
        int tahunSekarang = LocalDate.now().getYear();

        // Menghitung umur pengguna
        int umur = tahunSekarang - tahunLahir;

        // Menentukan jenis kelamin
        String jenisKelaminString;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') jenisKelaminString = "Laki-laki";
        else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            jenisKelaminString = "Perempuan";
        } else {
            jenisKelaminString = "Tidak diketahui";
        }

        // Menampilkan output
        System.out.println("\nData Diri Pengguna:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminString);
        System.out.println("Umur: " + umur + " tahun");
    }
}