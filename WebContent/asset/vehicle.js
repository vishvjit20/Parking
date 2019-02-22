$('document').ready(function(){
	$('#btn').click(function(){
		$.getJSON('SearchVehicleByRFIDJSON',{ajax:true,rfid:$('#rfid').val()},function(data){
			htm='Employee :'+data[0].EMPLOYEEID+"<br><br>";
			htm+='<table border=1 width=80%>';
			htm+='<caption><b><i>Vehicle Details</i></b></caption>';
			htm+='<tr><td><b><i>Vehicle Id</b></i></td><td>'+data[0].VEHICLEID+' '+data[0].REGISTRATIONNO+'</td><td><b><i>RFID</i></b></td><td>'+data[0].RFID_NO+'</td></tr>';
			htm+='<tr><td><b><i>Mobile no</i></b></td><td>'+data[0].MOBILENO+'</td><td><b><i>Entry Date/Entry Time</b></i></td><td>'+data[0].ENTRYDATE+' '+data[0].ENTRYTIME+'</td></tr>';
			htm+='<tr><td><b><i>Amount</i></b></td><td>'+data[0].AMOUNT+'</td><td><b><i>Time</i></b></td><td>'+data[0].TIME+'</td></tr>';
			htm+='<tr><td><b><i>Floor no</i></b></td><td>'+data[0].FLOORNO+'</td><td><b><i>Status</i></b></td><td>'+data[0].STATUS+'</td></tr>';
			htm+='</table>';
			today = new Date();
			cd=today.getFullYear()+"/"+today.getMonth()+"/"+today.getDate();
			ct=today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
			htm+='<form action=ExitVehicleSubmit>';
			htm+='<input type=hidden value='+data[0].VEHICLEID+' name=vid>';
			htm+='<table width=80%><tr><td><b><i>Exit Date :</i></b></td><td><input type=text name=exitdate value='+cd+'></td><td><b><i>Exit Time :</i></b></td><td><input type=text name=exittime value='+ct+'></td></tr></table>';
            htm+='<br><br>';
            htm+="<input type=submit value=Confirm Exit></form>";
            $('#result').html(htm);
		});
	});
});