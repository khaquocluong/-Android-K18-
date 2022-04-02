package com.example.android2022_1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.android2022_1.model.Restaurant
import java.util.regex.Pattern

object DataStoreRes {
    fun getDataSet(): List<Restaurant> {
        return listOf(
            Restaurant(1,"Gấu Crepe & Milk Tea","108 Đường Số 1, P. 16, Quận Gò Vấp, TP. HCM",R.drawable.gau_crep),
            Restaurant(2,"Bánh Tráng Trộn & Cuốn - Lê Đức Thọ","57/38 Lê Đức Thọ, P. 7, Quận Gò Vấp TP. HCM",R.drawable.banhtranldt),
            Restaurant(3,"Bánh Mì Xíu Mại Gốc Đà Lạt"," 76 Đường Số 1, P. 16, Quận Gò VấpTP. HCM",R.drawable.bmxm),
            Restaurant(4,"Phở Vị Hoàng","2 - 4 Lê Lai, P. 3, Quận Gò VấpTP. HCM",R.drawable.pho),
            Restaurant(5,"HUP Acoustic Cafe - Nguyễn Văn Lượng","312 Nguyễn Văn Lượng, P. 16, Quận Gò VấpTP. HCM",R.drawable.cf2),
            Restaurant(6,"Siucha - Trà Sữa","204 Lê Văn Thọ, P. 11, Quận Gò Vấp, TP. HCM",R.drawable.tsua),
            Restaurant(7,"Bánh Tráng Trộn & Cuốn - Lê Đức Thọ","57/38 Lê Đức Thọ, P. 7, Quận Gò Vấp TP. HCM",R.drawable.tranbanh),
            Restaurant(8,"Hủ Tiếu Miền Tây - Nguyễn Văn Bảo","\"Hẻm 59 Nguyễn Văn Bảo, P. 4, P. 16, Quận Gò VấpTP. HCM",R.drawable.photo),
            Restaurant(9,"Phở Lộc - Quang Trung","96 Quang Trung, P. 10, Quận Gò VấpTP. HCM",R.drawable.batpho),
            Restaurant(10,"Cò Kếu Bờ Sông - Quán Ăn Ven Sông","147B Đường Số 23 , P. 5, Quận Gò VấpTP. HCM",R.drawable.quannuong),
            Restaurant(11,"Simple Coffee - Acoustic Live","498 Cây Trâm, P. 9, Quận Gò VấpTP. HCM",R.drawable.quacf1),
            Restaurant(12,"Coconut Coffee","730/46 Lê Đức Thọ, P. 15, Quận Gò VấpTP. HCM",R.drawable.quancafe),
            Restaurant(13,"Bánh Heo Quay"," 760 Đường Số 12, P. 6, Quận Gò VấpTP. HCM",R.drawable.heoquay),
            Restaurant(14,"The Check In - Sữa Đậu Nành & Sữa Chua Lắc","381 Lê Văn Thọ, P. 9 Quận Gò Vấp TP. HCM",R.drawable.hongtra),
            Restaurant(15,"Quán Sen - Nhậu Bình Dân","310/29A Đường15, Dương Quảng Hàm, P. 5, Quận Gò VấpTP. HCM",R.drawable.quannhau),
            Restaurant(16,"Trà Sữa Nhà Làm - Quang Trung","656/65/4 Quang Trung, P. 11, Quận Gò VấpTP. HCM",R.drawable.quansen),
            Restaurant(17,"My Way Cafe - Phan Văn Trị"," 18 Phan Văn Trị, Phường 10, Quận Gò VấpTP. HCM",R.drawable.trasua),

            Restaurant(18,"Quán Xuân - Cháo Gỏi Vịt","35 -37 Lê Văn Thọ , P.8, Quận Gò VấpTP. HCM",R.drawable.quannuong),
            Restaurant(19,"Bún Đậu Ngon Cây Trâm","298 Cây Trâm, P. 9, Quận Gò VấpTP. HCM",R.drawable.batpho),
            Restaurant(20,"Fins Coffee - Cây Trâm","8 Cây Trâm, P. 9, Quận Gò VấpTP. HCM",R.drawable.quancafe),
            )
    }
}

class DataStore(context : Context?) : SQLiteOpenHelper(context, "course.db", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "Create table users (email text primary key, password text)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
    //add User
    fun addUser(email: String, password: String){
        var db = this.writableDatabase
        var values = contentValuesOf()
        values.put("email", email)
        values.put("password", password)
        db.insert("users", null, values)
    }
    //get user
    fun getUser(email: String, password: String):Boolean{
        var db = this.readableDatabase
        var cursor = db.rawQuery("select * from users where email = ? and password = ?", arrayOf(email, password))
        var ret = false
        if( cursor.count > 0){
            ret =  true
        }
        return ret
    }

    //check password
    fun checkPassword(password: String):Boolean{
        var ret = false
        if( PASSWOR_PATTERN.matcher(password).matches() ){
            ret =  true
        }
        return ret
    }
    var PASSWOR_PATTERN=
        Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                //"(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$")

}