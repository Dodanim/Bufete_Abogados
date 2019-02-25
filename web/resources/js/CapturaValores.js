/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function capturarCelda() {

    var sPageURL = window.location.search.substring(12);

    if (sPageURL === null || sPageURL === undefined) {
        //  document.getElementById("miFormularioI:referencia").value=sPageURL;
        var table = document.getElementById("miFormulario:dtBitacora");
        var celda = table.rows[1].cells[4].innerHTML;
        document.getElementById("miFormularioI:referencia").value = celda;
        // alert(table.rows[2].cells[4].innerHTML);

    } else {
        document.getElementById("miFormularioI:referencia").value = sPageURL;

    }
}
  PrimeFaces.locales['es'] = {
        closeText: 'kapat',
        prevText: 'geri',
        nextText: 'ileri',
        currentText: 'Fecha Actual',
        monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
            'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
            'Jul','Ago','Sep','Oct','Nov','Dic'],
        dayNames: ['Domingo','Lunes','Martes','Miercoles','Jueves','Viernes','Sabado'],
        dayNamesShort: ['Dom','Ln','Mar','Mie','Jue','Vie','Sab'],
        dayNamesMin: ['Dom','Ln','Mar','Mie','Jue','Vie','Sab'],
        weekHeader: 'Semana',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        month: 'Mes',
        week: 'Semana',
        day: 'Dia',
        allDayText : 'Dia'
    };