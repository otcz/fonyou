
$(document).ready(function() {
//onready QUEDE 2:52:52
});

 async function registrarUsuario(){
 let dato={};
 dato.nombre=document.getElementById("txtNombre").value;
 dato.apellidos=document.getElementById("txtApellidos").value;
 dato.email=document.getElementById("txtEmail").value;
 dato.password=document.getElementById("txtPassword").value;
 let repetirPassword= document.getElementById("txtRepetirPassword").value;

 if (repetirPassword != dato.password) {
   alert('La contraseña que escribiste es diferente.');
   return;
 }

 const request = await fetch('api/usuarios', {
   method: 'POST',
   headers: {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
   },
   body: JSON.stringify(dato)

 })();
 alert("La cuenta fue creada con exito!");
 window.location.href = 'login.html'
}
