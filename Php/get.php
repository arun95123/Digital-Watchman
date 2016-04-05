<?php
$db=$mysql_connect('localhost','root','');
$dbfound=mysql_select_db('data');
if($dbfound)
{
$sql='select $pinname from data';
$pinname=$_get['pin'];
$result=mysql_query($sql);
$reg_array=array();

if(isset($_get['pin'])
{

if($pinname=='gpin')
{
$reg_array['success']=1;
$reg_array['pinvalue']=$result;

}
else if($pinname=='apin')
{
$reg_array['success']=1;
$reg_array['pinvalue']=$result;
}
else if($pinname=='vpin')
{
$reg_array['success']=1;
$reg_array['pinvalue']=$result;
}
echo json_encode($reg_array);


}
}
?>