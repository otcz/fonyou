
$(document).ready(function() {
    cargarUsuario();
  $('#usuarios').DataTable();
  actualizarDatosusuario();
});


function actualizarDatosusuario(){
  document.getElementById("txtEmailUser").outerHTML=localStorage.email;
}

 async function cargarUsuario(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeader()
  });
  const usuarios = await request.json();
  
  let listadoHTML=""; 
  for (let usuario of usuarios){
    let botonEliminar='<a href="#"onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let telefono = usuario.telefono==null? '-':usuario.telefono;
    let usuarioHtml ='<tr><td>'+usuario.id+'</td> <td>'+usuario.nombre+" "+usuario.apellidos+'</td><td>'+usuario.email+'</td><td>'+telefono+'</td><td>'+botonEliminar+'</td></tr>';
    listadoHTML +=usuarioHtml;
  }

 
  document.querySelector('#tabla_usuario TBODY').outerHTML=listadoHTML;


}


async function eliminarUsuario(id){
  if(!confirm('Desea eliminar')){
    return;
  }
  const request = await fetch('api/usuarios/'+id, {
    method: 'DELETE',
    headers: getHeader()
  });
location.reload();

}

function getHeader()
{
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization':localStorage.token
  };
}

