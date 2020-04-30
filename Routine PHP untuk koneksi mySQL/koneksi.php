
<?php
 /*
 Ivan Surya Hutomo
 Routine untuk mengkoneksikan aplikasi GadgetX ke sql menggunakan php
 */
 
//Mendefinisikan konstanta koneksi
 define('HOST','sql201.epizy.com');
 define('USER','epiz_22233756');
 define('PASS','VXFK3bWzGHOW');
 define('DB','epiz_22233756_gadgetX');
 
 //membuat koneksi dengan database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 ?>