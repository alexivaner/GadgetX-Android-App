<?php 
 
 /*
 
Ivan Surya H
 */
 
 //Mendapatkan Nilai ID
 $id = $_GET['id'];
 
 //Import File Koneksi Database
 require_once('koneksi.php');
 
 //Membuat SQL Query
 $sql = "DELETE FROM tb_smartphone WHERE id=$id;";
 
 
 //Menghapus Nilai pada Database 
 if(mysqli_query($con,$sql)){
 echo 'Berhasil Menghapus Data Smartphone';
 }else{
 echo 'Gagal Menghapus Data Smartphone';
 }
 
 mysqli_close($con);
 ?>