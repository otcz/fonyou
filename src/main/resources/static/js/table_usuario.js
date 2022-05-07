
$(document).ready(function() {
    cargarUsuario();
  $('#usuarios').DataTable();
});

 async function cargarUsuario(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();
  
  let listadoHTML=""; 
  console.log(usuarios);
  for (let usuario of usuarios){
    let botonEliminar='<a href="#"onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let usuarioHtml ='<tr><td>'+usuario.id+'</td> <td>'+usuario.snombre+" "+usuario.sapellidos+'</td><td>'+usuario.semail+'</td><td>'+usuario.spassword+'</td><td>'+botonEliminar+'</td></tr>';
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
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
location.reload();

}