#!/usr/bin/env php
<?php

/**
 * you cannot execute this script within Eclipse PHP
 * because of the limited output buffer. Try to run it
 * directly within a shell.
 */

require_once dirname(__FILE__) . '/../src/PHPSQLParser.php';
$parser = new PHPSQLParser();
// var_dump($parser);
// var_dump($argv);
// echo "Argsize =\n";
// echo sizeof($argv) . "\n";
if(sizeof($argv)<2){
  // echo "Not enough arguments...\n";
  // echo "Checking if url parameter";


  $sql = $_GET['kqlq'];
  echo json_encode($parser->parse($sql, true));
  // echo "First argument has to be KQL query\n";
  // exit(1);
}
else{
	$sql = $argv[1];
	// echo json_encode($parser->parse($sql, true));
	print_r(json_encode($parser->parse($sql, true)));

}
/* You can use the ->parse() method too.  The parsed structure is returned, and 
   also available in the ->parsed property. */
// $sql = 'SELECT \'a,b,c\'
//           from \'some_table an_alias\'
// 	where \'d > 5;\'';
// $sql = $argv[1];
//echo "Printing output\n" . $sql . "\n";

//print_r($parser->parse($sql, true));
/*Test*/
//echo "\nPrinting as json\n";
// print_r(json_encode($parser->parse($sql, true)));
// echo json_encode($parser->parse($sql, true))
//echo "\n";

?>
