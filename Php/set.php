<?php

if(isset($_get['value'])&&isset([$_get['pin'])7:43 PM 4/1/2016)
{
$pinname=$_get['pin'];
$val=$_get['value'];
$dbhandle=mysql_connect('localhost','root','');
$dbfound=mysql_select_db('data');




if($dbfound)
{

$sql='update data set gpin=$val';
if($pinname=='gpin')
{
$result=mysql_query($sql);


}
else if($pinname=='apin')
{

$result=mysql_query($sql);

}
else if($pinname=='vpin')
{

$result=mysql_query($sql);
}

}}
?>