 <?php
 /*
Ivan Surya H
 */
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$name = $_POST['name'];
		$network = $_POST['network'];
		$stat = $_POST['stat'];
		$dim = $_POST['dim'];
		$disty = $_POST['disty'];
		$disz = $_POST['disz'];
		$cpu = $_POST['cpu'];
		$os = $_POST['os'];
		$memory = $_POST['memory'];
		$camera = $_POST['camera'];
		$batt = $_POST['batt'];
		$brand = $_POST['brand'];

		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE tb_pegawai SET NAME = '$name', NETWORK = '$network', STATUS = '$stat'
		, DIMENSION = '$dim', DISPLAY_TYPE = '$disty', DISPLAY_SIZE = $disz, CPU = '$cpu'
		, OS = '$os', MEMORY = '$memory', CAMERA = '$camera', BATTERY = '$batt', BRAND = '$brand'WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Smartphone';
		}else{
			echo 'Gagal Update Data Smartphone';
		}
		
		mysqli_close($con);
	}
?>