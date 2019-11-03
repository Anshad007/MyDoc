<?php
$username =$_POST['username'];
$password =$_POST['Password'];
$gender =$_POST['gender'];
$email =$_POST['email'];
$phonecode =$_POST['phonecode'];
$phone =$_POST['phone'];

if(!empty($username) || !empty($password) || !empty($gender) || !empty($email) || !empty($phonecode) || !empty($phone) )
{
$host ="localhost";
$dbusername ="root";
$dbpassword ="";
$dbname ="youtube" ;
    
    //create connection
    $conn = new mysqli($host, $dbusername, $dbpassword, $dbname);
    
    if(mysqli_connect_error()){
        die('connect error('. mysqli_connect_error().')' .mysqli_connect_error()); 
    } else{
        $SELECT ="SELECT email From register Where email =? Limit 1";
        $INSERT ="INSERT Into register (username, password, gender, email, phonecode, phone) values(?, ?, ?, ?, ?, ?)";
        
        //Preaper statement
        $stmt = $conn->preaper($SELECT);
        $stmt->bind_param("s",$email);
        $stmt->execute();
        $stmt->bind_result($email);
        $stmt->store_result();
        $rnum = $stmt->num_rows;
        
        if($rnum==0){
            $stmt->close)();
            
            $stmt =$conn->preaper($INSERT);
            $stmt->bind_param("ssssii", $username, $password, $gender, $email, $phonecode, $phone);
            $stmt->execute();
            echo "New record inserted sucessfully";
        } else{
            echo "someone already registerd using this email";
        }
        $stmt->close();
        $conn->closes();
    }
}  else {
    echo "All field are required";
    die();
}
?>