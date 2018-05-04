function exportChartInPDF1() {
   var docDefinition = {
      content: [
        'Line Chart','\n',
        'Analisis de las graficas',
        '\n',
        'En este caso se tienen las siguientes Graficas',

        {
           image: $(PF('char1').exportAsImage()).attr('src'),
           width: 200,
           height: 200

        },

      ]
   }
   pdfMake.createPdf(docDefinition).open();
   //pdfMake.createPdf(docDefinition).download('primefaces-charts.pdf');
}

function exportChartInPDF2() {
   var docDefinition = {
      content: [
        'Line Chart','\n',
        'Analisis de las graficas',
        '\n',
        'En este caso se tienen las siguientes Graficas',

        {
           image: $(PF('char2').exportAsImage()).attr('src'),
           width: 200,
           height: 200  

        },


      ]
   }
   pdfMake.createPdf(docDefinition).open();
   //pdfMake.createPdf(docDefinition).download('primefaces-charts.pdf');
}

function exportChartInPDF3() {
   var docDefinition = {
      content: [
        'Line Chart','\n',
        'Analisis de las graficas',
        '\n',
        'En este caso se tienen las siguientes Graficas',

        {
           image: $(PF('char3').exportAsImage()).attr('src'),
           width: 200,
           height: 200

        },


      ]
   }
   pdfMake.createPdf(docDefinition).open();
   //pdfMake.createPdf(docDefinition).download('primefaces-charts.pdf');
}

function exportChartInPDF4() {
   var docDefinition = {
      content: [
        'Line Chart','\n',
        'Analisis de las graficas',
        '\n',
        'En este caso se tienen las siguientes Graficas',

        {
           image: $(PF('char4').exportAsImage()).attr('src'),
           width: 200,
           height: 200

        },

      ]
   }
   pdfMake.createPdf(docDefinition).open();
}