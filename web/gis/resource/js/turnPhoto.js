/**
 *搜索框转换 
 */
function turnPhotoTab(id){
	var d = document;
	for(var i=1;i<=4;i++){
		if(i==id){
			d.getElementById("content"+i).style.display="block";
			d.getElementById("title"+i).className="dorp";
		}
		else{
			d.getElementById("content"+i).style.display="none";
			d.getElementById("title"+i).className="nodorp";
		}
	}
}
