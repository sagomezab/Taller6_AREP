function enviarSin() {
    var parm = document.getElementById("message").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/logservicefacade?msg=" + encodeURIComponent(parm), true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var resultado = xhr.responseText;
            console.log(resultado);
            document.getElementById("envio").innerText = resultado;
        }
    };
    xhr.send();
}
