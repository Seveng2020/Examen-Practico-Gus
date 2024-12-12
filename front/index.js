const begin = () => {
    cargarObrasSociales();
    cargarEspecialidades();
    document.getElementById("enviar").addEventListener('click', enviarFormulario);
  };
  
  const cargarObrasSociales = async () => {
    let selectContainer = document.getElementById("obraSocial");
  
    try {
      let resp = await fetch("http://localhost:8080/ooss/all");
      let obrasSociales = await resp.json();
  
      for (let obraSocial of obrasSociales) {
        let opt = document.createElement("option");
        opt.append(obraSocial.nombre);
        opt.setAttribute("value", obraSocial.id);
        selectContainer.appendChild(opt);
      }
    } catch (error) {
      console.error("Error al cargar obras sociales:", error);
    }
  };
  
  const cargarEspecialidades = async () => {
    let selectContainer = document.getElementById("especialidad");
  
    try {
      let resp = await fetch("http://localhost:8080/especialidad/all");
      let especialidades = await resp.json();
  
      for (let especialidad of especialidades) {
        let opt = document.createElement("option");
        opt.append(especialidad.nombre);
        opt.setAttribute("value", especialidad.id);
        selectContainer.appendChild(opt);
      }
    } catch (error) {
      console.error("Error al cargar especialidades:", error);
    }
  };
  
  const enviarFormulario = async () => {
    let feedback = document.getElementById("feedback");
  
    if (!feedback.classList.contains("d-none")) {
      feedback.classList.add("d-none");
    }
  
    let form = document.getElementById("form");
  
    let formData = {
      "nombre": document.getElementById("nombreCompleto").value.trim(),
      "dni": document.getElementById("dni").value.trim(),
      "email": document.getElementById("mail").value.trim(),
      "idObraSocial": document.getElementById("obraSocial").value,
      "idEspecialidad": document.getElementById("especialidad").value
    };
  
    // Validar el nombre
    if (!/^[a-zA-Z\s]{1,100}$/.test(formData.nombre)) {
      feedback.classList.remove("d-none");
      feedback.innerText = "El nombre no debe contener caracteres especiales y no debe superar los 100 caracteres.";
      return;
    }
  
    // Validar el DNI
    if (!/^\d{6,8}$/.test(formData.dni)) {
      feedback.classList.remove("d-none");
      feedback.innerText = "El DNI debe tener entre 6 y 8 caracteres numéricos.";
      return;
    }
  
    // Validar el correo electrónico
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
      feedback.classList.remove("d-none");
      feedback.innerText = "El correo electrónico no tiene un formato válido.";
      return;
    }
  
    try {
      let resp = await fetch("http://localhost:8080/solicitud/create", {
        method: "POST",
        body: JSON.stringify(formData),
        headers: { "Content-Type": "application/json" }
      });
      let respObj = await resp.json();
  
      if (respObj.exito) {
        feedback.classList.remove("d-none");
        feedback.innerText = "Enviado!";
      } else {
        feedback.classList.remove("d-none");
        feedback.innerText = respObj.mensaje;
      }
    } catch (error) {
      console.error("Error al enviar el formulario:", error);
      feedback.classList.remove("d-none");
      feedback.innerText = "Error al enviar el formulario.";
    }
  };
  
  window.onload = begin;
  