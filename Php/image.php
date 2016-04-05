<?php
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
// $id = $_GET['id'];

 
 header('content-type: image/jpeg');
 
 echo base64_decode('gowtham.jpg');
 
 mysqli_close($con);
 
 }else{
 echo "Error";
 }
?>
