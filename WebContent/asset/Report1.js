$('document').ready(function(){
	$('#btn').click(function(){
	$.getJSON('ReportBetweenTwoDatesJSON',{ajax:true,datefrom:$('#datefrom'),dateto:$('#dateto')},function(data){
	          	htm='Vehicle :'+data[0].VEHICLEID+"<br><br>";
	          	htm+='Employee :'+data[0].EMPLOYEEID+"<br><br>";
	          	htm+='Address :'+data[0].ADDRESS+"<br><br>";
	});
});
});