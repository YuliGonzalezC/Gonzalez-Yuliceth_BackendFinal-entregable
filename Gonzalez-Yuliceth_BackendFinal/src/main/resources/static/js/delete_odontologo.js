window.addEventListener('load', function () {
    document.getElementById('odontologoTableBody').addEventListener('click', function(e){
        if(e.target && e.target.nodeName == 'BUTTON'){
            Odontologoid = e.target.id.replace("be_","");

            if (window.confirm("Realmente quiere borrar al odontologo con ID: "+Odontologoid)) {
                const url = '/odontologos/'+Odontologoid;
                const settings = {
                    method: 'DELETE',
                }
                fetch(url, settings)
                .then(response => response.json())
                .then(data => {
                    let successAlert =  '<div class="alert alert-success alert-dismissible">' +
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong></strong> Odontologo eliminado </div>'
                    document.querySelector('#response').innerHTML = successAlert;
                    document.querySelector('#response').style.display = "block";

                    window.setTimeout(function(){
                        window.location.href = "/odontologos.html";
                    }, 1500);
                })
                .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'
                    document.querySelector('#response').innerHTML = errorAlert;
                    document.querySelector('#response').style.display = "block";
                });
            }
        }
    })
})