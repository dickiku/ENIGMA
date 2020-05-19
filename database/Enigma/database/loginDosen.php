<?php

    include('koneksi.php');
    $email = $_POST['email'];
    $password = $_POST['pass'];

    $Sql_Query = "SELECT * FROM dosen WHERE email = '$email' and password = '$password' ";

    $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));

    if(isset($check)){

     echo "Data Matched";
     $result = array();
     array_push($result,array(
             "id"=>$check['id'],
             "nip"=>$check['nip'],
             "nama"=>$check['nama'],
             "email"=>$check['email'],
             "pass"=>$check['password']
         ));
     echo json_encode(array('result'=>$result));
    }
    else{
     echo "Invalid Username or Password Please Try Again";
    }
    mysqli_close($con);

?>