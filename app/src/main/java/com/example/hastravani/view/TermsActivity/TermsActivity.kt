package com.example.hastravani.view.TermsActivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hastravani.R

class TermsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        // Temukan view berdasarkan ID-nya
        val termsContentTextView = findViewById<TextView>(R.id.txt_terms_content)

        // Atur teks syarat dan ketentuan
        termsContentTextView.text = """
            Tanggal Berlaku: 10 Desember 2024
            Selamat datang di HastraVani. Dengan menggunakan aplikasi ini, Anda menyetujui syarat dan ketentuan yang ditetapkan di bawah ini. Harap baca dengan saksama sebelum menggunakan layanan kami.
            
            1. Definisi
            1.1 Aplikasi: Aplikasi terjemahan bahasa isyarat yang membantu pengguna memahami dan berkomunikasi menggunakan bahasa isyarat.
            1.2 Layanan: Fitur yang tersedia di dalam aplikasi, termasuk terjemahan bahasa isyarat ke teks.
            1.3 Pengguna: Semua individu yang menggunakan aplikasi ini.
            
            2. Persetujuan Pengguna
            Dengan mengunduh dan menggunakan aplikasi, Anda:
            - Menyatakan telah membaca, memahami, dan menyetujui Syarat dan Ketentuan ini.
            - Menyatakan bahwa Anda berusia minimal 13 tahun atau memiliki izin dari orang tua/wali untuk menggunakan aplikasi ini.
            
            3. Penggunaan Aplikasi
            3.1 Tujuan Non-Komersial: Aplikasi ini hanya boleh digunakan untuk tujuan pribadi dan non-komersial. Penggunaan untuk tujuan lain memerlukan izin tertulis dari pengembang aplikasi.
            3.2 Kepatuhan terhadap Hukum: Pengguna bertanggung jawab untuk menggunakan aplikasi sesuai dengan hukum dan peraturan yang berlaku.
            3.3 Pembaruan dan Perubahan: Pengembang berhak untuk memperbarui aplikasi kapan saja tanpa pemberitahuan sebelumnya.
            
            4. Privasi Data
            4.1 Pengumpulan Data: Kami dapat mengumpulkan data yang Anda masukkan atau hasil terjemahan untuk meningkatkan layanan, sesuai dengan Kebijakan Privasi kami.
            4.2 Keamanan Data: Kami berupaya menjaga keamanan data Anda tetapi tidak bertanggung jawab atas pelanggaran keamanan yang disebabkan oleh pihak ketiga.
            
            5. Tanggung Jawab Pengguna
            5.1 Pengguna bertanggung jawab atas interpretasi hasil terjemahan dan konsekuensi dari penggunaannya.
            5.2 Aplikasi ini adalah alat bantu, dan hasil terjemahan mungkin tidak sepenuhnya akurat. Kami menyarankan pengguna untuk memverifikasi hasil dengan sumber lain jika diperlukan.
            
            6. Pembatasan Tanggung Jawab
            Kami tidak bertanggung jawab atas kerugian atau kerusakan yang diakibatkan oleh:
            - Kesalahan atau ketidakakuratan hasil terjemahan.
            - Ketidakmampuan pengguna untuk mengakses aplikasi karena kendala teknis.
            - Penggunaan aplikasi yang melanggar hukum atau hak pihak ketiga.
            
            7. Pelanggaran dan Penangguhan Akun
            Kami berhak untuk menangguhkan atau menghentikan akses pengguna jika ditemukan pelanggaran terhadap Syarat dan Ketentuan ini tanpa pemberitahuan sebelumnya.
            
            8. Hak Kekayaan Intelektual
            Seluruh konten, desain, dan teknologi dalam aplikasi ini adalah milik pengembang dan dilindungi oleh undang-undang hak cipta. Pengguna tidak diperkenankan menyalin, memodifikasi, atau mendistribusikan bagian mana pun dari aplikasi tanpa izin tertulis.
            
            9. Perubahan Syarat dan Ketentuan
            Kami dapat mengubah Syarat dan Ketentuan ini kapan saja. Perubahan akan diberlakukan setelah diumumkan melalui aplikasi atau situs web resmi kami.
            
            10. Hukum yang Berlaku
            Syarat dan Ketentuan ini tunduk pada hukum yang berlaku di Indonesia.
            
            Kontak Kami
            Jika Anda memiliki pertanyaan tentang Syarat dan Ketentuan ini, silakan hubungi kami melalui Hastravani@gmail.com.
            
            Terima kasih telah menggunakan HastraVani!
        """.trimIndent()
    }
}