var blogeo = document.getElementById('singin');
blogeo.addEventListener('click', function(){ 
    var e = document.getElementById('email').value;
    var p = document.getElementById('password'.value);
    const parametros = new URLSearchParams();
    parametros.append('PrmEmail', e);
    parametros.append('PrmPassword', p);
    axios.get('http://localhost/adios')
    .then(function(response){ 
        console.log(response)
        console.log('contenido: '+ response.data)
        console.log('estatus: '+ response.status)
        document.getElementById('titulo').innerHTML = response.data
    })
    .catch(function(error){
        console.groupCollapsed(error)
    })

})