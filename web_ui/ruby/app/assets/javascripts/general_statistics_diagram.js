google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {
  var persons_dom = document.getElementsByName('person');
  var rank_dom = document.getElementsByName('rank');

  var data = google.visualization.arrayToDataTable([
    arrForDiagrammFromDom( '', persons_dom ),
    arrForDiagrammFromDom( 'Персоны', rank_dom, true )
  ]);
  var options = {
    title: 'Общая статистика',
    hAxis: {title: 'Имя персоны'},
    vAxis: {title: 'Кол-во упоменаний на сайте, тысяч'}
  };
  var chart = new google.visualization.ColumnChart(document.getElementById('general_diagram'));
  var persons_rank_table = document.getElementById('persons_rank');
  if (persons_rank_table) {
    chart.draw(data, options)
  };
};

function arrForDiagrammFromDom(first_value, dom_collection, number = false) {
  var resultArr = [first_value];
  for (var i = 0; i < dom_collection.length; i++) {
    var text;
    if (number) {
      text = +dom_collection[i].innerText
    } else {
      text = dom_collection[i].innerText
    }
    resultArr.push( text )
  };
  return resultArr
}
