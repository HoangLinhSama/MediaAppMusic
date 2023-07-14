package com.hoanglinhsama.mediaappmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textViewSong, textViewSinger, textViewLongCurrent, textViewLong;
    private ImageView imageViewSinger, imageViewPrevious, imageViewPlay, imageViewNext;
    private SeekBar seekBarProcessSong;
    private ArrayList<Song> arrayListSong;
    private int currentSong = 0; // luu thong tin vi tri trong arrayList cua bai hat dang phat, mac dinh se cho = 0, tuc la lan dau se la mo bai hat dau tien trong danh sach
    private MediaPlayer mediaPlayer;
    private SimpleDateFormat simpleDateFormat;
    private Animation animation;

    private void mapping() {
        this.textViewSong = findViewById(R.id.textViewSong);
        this.textViewSinger = findViewById(R.id.textViewSinger);
        this.textViewLongCurrent = findViewById(R.id.textViewLongCurrent);
        this.textViewLong = findViewById(R.id.textViewLong);
        this.imageViewSinger = findViewById(R.id.imageViewSinger);
        this.imageViewPrevious = findViewById(R.id.imageViewPrevious);
        this.imageViewPlay = findViewById(R.id.imageViewPlay);
        this.imageViewNext = findViewById(R.id.imageViewNext);
        this.seekBarProcessSong = findViewById(R.id.seekBarProcessSong);
    }

    private void initialization() {
        this.arrayListSong = new ArrayList<>();
        this.arrayListSong.add(new Song("Âm Thầm Bên Em", "Sơn Tùng MTP", R.raw.am_tham_ben_em, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Anh Sai Rồi", "Sơn Tùng MTP", R.raw.anh_sai_roi, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Bình Yên Nơi Đâu", "Sơn Tùng MTP", R.raw.binh_yen_noi_dau, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Buông Đôi Tay Nhau Ra", "Sơn Tùng MTP", R.raw.buong_doi_tay_nhau_ra, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Chắc Ai Đó Sẽ Về", "Sơn Tùng MTP", R.raw.chac_ai_do_se_ve, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Chúng Ta Của Hiện Tại", "Sơn Tùng MTP", R.raw.chung_ta_cua_hien_tai, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Chúng Ta Không Thuộc Về Nhau", "Sơn Tùng MTP", R.raw.chung_ta_khong_thuoc_ve_nhau, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Cơn Mưa Ngang Qua", "Sơn Tùng MTP", R.raw.con_mua_ngang_qua, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Cơn Mưa Ngang Qua Part 2", "Sơn Tùng MTP", R.raw.con_mua_ngang_qua_part_2, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Cơn Mưa Ngang Qua Part 3", "Sơn Tùng MTP", R.raw.con_mua_ngang_qua_part_3, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Đừng Về Trễ", "Sơn Tùng MTP", R.raw.dung_ve_tre, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Em Của Ngày Hôm Qua", "Sơn Tùng MTP", R.raw.em_cua_ngay_hom_qua, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Em Đừng Đi", "Sơn Tùng MTP", R.raw.em_dung_di, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Hãy Trao Cho Anh", "Sơn Tùng MTP", R.raw.hay_trao_cho_anh, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Không Phải Dạng Vừa Đâu", "Sơn Tùng MTP", R.raw.khong_phai_dang_vua_dau, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Khuôn Mặt Đáng Thương", "Sơn Tùng MTP", R.raw.khuon_mat_dang_thuong, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Làm Người Luôn Yêu Em", "Sơn Tùng MTP", R.raw.lam_nguoi_luon_yeu_em, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Lệ Anh Vẫn Rơi", "Sơn Tùng MTP", R.raw.le_anh_van_roi, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Mai Này Con Lớn Nên", "Sơn Tùng MTP", R.raw.mai_nay_con_lon_len, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Một Cộng Một Lớn Hơn Hai", "Sơn Tùng MTP", R.raw.mot_cong_mot_lon_hon_hai, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Một Mình Cô Đơn", "Sơn Tùng MTP", R.raw.mot_minh_co_don, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Một Năm Mới Bình An", "Sơn Tùng MTP", R.raw.mot_nam_moi_binh_an, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Nắng Ấm Xa Dần", "Sơn Tùng MTP", R.raw.nang_am_xa_dan, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Như Ngày Hôm Qua ", "Sơn Tùng MTP", R.raw.nhu_ngay_hom_qua, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Remember Me", "Sơn Tùng MTP", R.raw.remember_me, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Thái Bình Mồ Hôi Rơi", "Sơn Tùng MTP", R.raw.thai_binh_mo_hoi_roi, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("There Is No One At All", "Sơn Tùng MTP", R.raw.there_is_no_one_at_all, R.drawable.son_tung_mtp));
        this.arrayListSong.add(new Song("Tình Yêu Trong Mắt Em", "Sơn Tùng MTP", R.raw.tinh_yeu_trong_mat_em, R.drawable.son_tung_mtp));
    }

    private void initializationInformationSong() {
        textViewSong.setText(arrayListSong.get(currentSong).getSong());
        textViewSinger.setText(arrayListSong.get(currentSong).getSinger());
        imageViewSinger.setImageResource(arrayListSong.get(currentSong).getPicture());
    }

    private void getLong() { // lay ra thoi luong cua bai hat khi play, pre, next
        simpleDateFormat = new SimpleDateFormat("mm:ss");
        textViewLong.setText(simpleDateFormat.format(mediaPlayer.getDuration())); // getDuration tra ve thoi luong cua file mp3 don vi ms
        seekBarProcessSong.setMax(mediaPlayer.getDuration()); // dat max cua seekbar la thoi luong cua mediaplayer de khi keo seekbar se ra dung vi tri nhac (thoi gian) can phat
    }

    private void getLongCurrent() {
        new CountDownTimer(mediaPlayer.getDuration() + 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                seekBarProcessSong.setProgress(mediaPlayer.getCurrentPosition()); // tuong tu nhu khi seekTo  (cai process voi thoi gian hien tai cua bai hat no bang nhau, do do co the setProcess bang currentPosition)
                textViewLongCurrent.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition())); // getCurrentPosition de tra ve vi tri phat hien tai
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // bat su kien khi bai hat da phat xong, de o day cho tien vi method getLongCurrent deu duoc goi trong ca play, next, pre nen do phai viet lai 3 lan trong play,next, pre
                    @Override
                    public void onCompletion(MediaPlayer mp) { // khi da phat xong bai hat thi chuyen qua bai ke tiep, coppy code cua next la xong
                        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate); // hieu ung quay cho imageViewSinger
                        imageViewSinger.startAnimation(animation);
                        if (mediaPlayer.isPlaying()) { // neu bai hat hien tai dang phat thi
                            mediaPlayer.stop(); // dung bai hat hien tai de phat bai tiep theo
                            mediaPlayer.release(); // giai phong tai nguyen khi stop bai hat
                        }
                        currentSong += 1; // chuyen sang phan tu ke tiep trong arrayList Song
                        if (currentSong > arrayListSong.size() - 1) // neu bai hat cuoi cung trong list muon next tiep thi se quay ve bai dau tien cua array list
                            currentSong = 0;
                        initializationInformationSong(); // khoi tao thong tin cho bai hat
                        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayListSong.get(currentSong).getFileMp3());
                        mediaPlayer.start(); // khi chuyen qua bai hat khac la tu dong phat
                        imageViewPlay.setImageResource(R.drawable.pause); // tuong tu cung chuyen icon thanh pause
                        getLong();
                        getLongCurrent();
                    }
                });
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mapping();
        this.initialization();
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayListSong.get(currentSong).getFileMp3()); // de ben ngoai su kien click butotn de chi phai khoi tao mot lan
        this.imageViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate); // hieu ung quay cho imageViewSinger
                imageViewSinger.startAnimation(animation);
                initializationInformationSong();
                if (mediaPlayer.isPlaying()) { // neu dang phat thi click se tam dung va doi icon thanh icon play
                    mediaPlayer.pause();
                    imageViewPlay.setImageResource(R.drawable.play);
                } else // tuc la chua phat thi click de phat va doi icon ve pause
                {
                    mediaPlayer.start(); // start de bat dau phat hoac tiep tuc phat neu truoc do bi tam dung (tuc la da goi pause)
                    imageViewPlay.setImageResource(R.drawable.pause);
                }
                getLong();
                getLongCurrent();
            }
        });
        this.imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate); // hieu ung quay cho imageViewSinger
                imageViewSinger.startAnimation(animation);
                if (mediaPlayer.isPlaying()) { // neu bai hat hien tai dang phat thi
                    mediaPlayer.stop(); // dung bai hat hien tai de phat bai tiep theo
                    mediaPlayer.release(); // giai phong tai nguyen khi stop bai hat
                }
                currentSong += 1; // chuyen sang phan tu ke tiep trong arrayList Song
                if (currentSong > arrayListSong.size() - 1) // neu bai hat cuoi cung trong list muon next tiep thi se quay ve bai dau tien cua array list
                    currentSong = 0;
                initializationInformationSong(); // khoi tao thong tin cho bai hat
                mediaPlayer = MediaPlayer.create(MainActivity.this, arrayListSong.get(currentSong).getFileMp3());
                mediaPlayer.start(); // khi chuyen qua bai hat khac la tu dong phat
                imageViewPlay.setImageResource(R.drawable.pause); // tuong tu cung chuyen icon thanh pause
                getLong();
                getLongCurrent();
            }
        });
        this.imageViewPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate); // hieu ung quay cho imageViewSinger
                imageViewSinger.startAnimation(animation);
                if (mediaPlayer.isPlaying()) { // neu bai hat hien tai dang phat thi
                    mediaPlayer.stop(); // dung bai hat hien tai
                    mediaPlayer.release(); // giai phong tai nguyen khi stop bai hat
                }
                currentSong -= 1; // chuyen sang phan tu lien truoc trong arrayList Song
                if (currentSong < 0) // neu bai hat hien tai la bai dau tien trong arrayList thi ma muon pre thi se quay ve bai hat cuoi cung trong array  list
                    currentSong = arrayListSong.size() - 1;
                initializationInformationSong(); // khoi tao thong tin cho bai hat
                mediaPlayer = MediaPlayer.create(MainActivity.this, arrayListSong.get(currentSong).getFileMp3());
                mediaPlayer.start(); // khi chuyen qua bai hat khac la tu dong phat
                imageViewPlay.setImageResource(R.drawable.pause); // tuong tu cung chuyen icon thanh pause
                getLong();
                getLongCurrent();
            }
        });
        this.seekBarProcessSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // khi process thay do

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // khi bat dau cham vao seekbar (tua den vi tri nhac duoc cham), khi cham vao la se cap nhat process
                mediaPlayer.seekTo(seekBar.getProgress()); // seekTo de di chuyen den vi tri thoi gian xac dinh, thoi gian do chinh la process do da set max cua seekbar = duration cua bai hat
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { // khi khong keo seekbar nua ma tha tay ra (khi keo seekbar den vi tri nhac muon tua), khi tha tay ra thi no moi cap nhat process
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }
}