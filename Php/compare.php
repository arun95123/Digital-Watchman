<?php
$pinno=$_GET['pinno'];
mysql_connect('localhost','root','raikiri');
$dbfound=mysql_select_db('data');
echo "lol";
if($dbfound)
{$sql='select * from data';
$result=mysql_query($sql);
$row=mysql_fetch_assoc($result);
if($pinno==$row['pinno'])
{$sql='update data set apin=1';
$sql='select * from data';
$res=mysql_fetch_assoc($sql);

while(1)
{
if($res['gpin']==1)
{
header('Location:/b.html');
}
else if($res['apin']==2)
{
while(1)
{
    if($res['gpin']==1)
     {
$sql='update data set apin=3';
mysql_query($sql);
       header('Location:/b.html');
     }
  else if($res['gpin']==3)
    {
     $sql='update data set apin=2';
     mysql_query($sql);
    }
}}}
}
}

?>
