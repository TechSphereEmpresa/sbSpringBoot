function addAgendamento() {
    const hora = document.getElementById("event-time").value;
    const nome = document.getElementById("event-input").value;
    const telefone = document.getElementById("event-tel").value;
    const servico = document.getElementById("event-service").value;

    fetch('/api/agenda', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ hora, nome, servico })
    });
}

function addCliente() {
    const nome = document.getElementById("event-input").value;
    const telefone = document.getElementById("event-tel").value;
    fetch('/api/clientes', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, telefone })
    });

}
