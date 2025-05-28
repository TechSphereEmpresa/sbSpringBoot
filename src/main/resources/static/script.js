function adicionarUsuario() {
    const hora = document.getElementById("event-time").value;
    const nome = document.getElementById("event-input").value;
    const servico = document.getElementById("event-service").value;

    fetch('/api/agenda', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ hora, nome, servico })
    })
        .then(() => {
            document.getElementById("hora").value = '';
            document.getElementById("nome").value = '';
            document.getElementById("servico").value = '';
            carregarAgenda();
        });
}
