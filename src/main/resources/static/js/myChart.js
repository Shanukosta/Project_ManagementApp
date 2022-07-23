var chartDataStr = decodeHtml(chartData);
var chartDataJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartDataJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i<arrayLength; i++){
	numericData[i]= chartDataJsonArray[i].stageCount;
	labelData[i]= chartDataJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
	type:'pie',
	//The data for our dataset
	data: {
		labels: labelData,
		datasets: [{
			label: 'My First dataset',
			backgroundColor: ["#3498DB", "#48C9B0", "#CD6155"],
			data: numericData 
		}]
	},
	
	//Configuration options
	options: {
		title: {
			display: true,
			text: 'Project Status'
		}
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}