const daysContainer = document.getElementById('days');
const monthYear = document.getElementById('month-year');
const prevBtn = document.getElementById('prev-month');
const nextBtn = document.getElementById('next-month');
const selectedDateElem = document.getElementById('selected-date');
const eventList = document.getElementById('event-list');
const eventInput = document.getElementById('event-input');
const eventTime = document.getElementById('event-time');
const addEventBtn = document.getElementById('add-event');
const clientNameInput = document.getElementById('event-input'); // Novo input para nome do cliente
const eventService = document.getElementById('event-service'); //  Pegando o select



let date = new Date();
let selectedDate = null;

let events = JSON.parse(localStorage.getItem('events')) || {};

function saveEvents() {
  localStorage.setItem('events', JSON.stringify(events));
}

function renderCalendar() {
  const year = date.getFullYear();
  const month = date.getMonth();

  const firstDay = new Date(year, month, 1).getDay();
  const lastDate = new Date(year, month + 1, 0).getDate();

  monthYear.innerText = `${date.toLocaleString('pt-br', { month: 'long' })} ${year}`;

  daysContainer.innerHTML = '';

  for (let i = 0; i < firstDay; i++) {
    const empty = document.createElement('div');
    daysContainer.appendChild(empty);
  }

  for (let day = 1; day <= lastDate; day++) {
    const dayElem = document.createElement('div');
    dayElem.classList.add('day');
    dayElem.innerText = day;

    const currentDate = `${year}-${month + 1}-${day}`;
    if (currentDate === getToday()) {
      dayElem.classList.add('today');
    }

    if (selectedDate === currentDate) {
      dayElem.classList.add('selected');
    }

    dayElem.addEventListener('click', () => {
      selectedDate = currentDate;
      selectedDateElem.innerText = formatDate(currentDate);
      renderCalendar();
      renderEvents();
    });

    daysContainer.appendChild(dayElem);
  }
}

function getToday() {
  const today = new Date();
  return `${today.getFullYear()}-${today.getMonth() + 1}-${today.getDate()}`;
}

function formatDate(dateStr) {
  const [y, m, d] = dateStr.split('-');
  return `${d.padStart(2, '0')}/${m.padStart(2, '0')}/${y}`;
}

function renderEvents() {
  eventList.innerHTML = '';
  if (!selectedDate) return;

  const dayEvents = events[selectedDate] || [];
  dayEvents
    .sort((a, b) => a.time.localeCompare(b.time)) // Ordena por horário
    .forEach((ev, index) => {
      const evDiv = document.createElement('div');
      evDiv.className = 'event';

      const content = document.createElement('div');
      content.className = 'event-content';
      /*content.innerText = `${ev.time} - ${ev.text}`;*/
      content.innerText = `${ev.time} | Cliente: ${ev.text} | Serviço: ${ev.service}`; // <- Aqui é a formatação elegante

      /*content.addEventListener('click', () => editEvent(index));*/

      const deleteBtn = document.createElement('button');
      deleteBtn.innerText = 'x';
      deleteBtn.onclick = () => deleteEvent(index);

      evDiv.appendChild(content);
      evDiv.appendChild(deleteBtn);

      eventList.appendChild(evDiv);
    });
}

function deleteEvent(index) {
  if (!selectedDate) return;
  events[selectedDate].splice(index, 1);
  if (events[selectedDate].length === 0) {
    delete events[selectedDate];
  }
  saveEvents();
  renderEvents();
}

/*function editEvent(index) {
  const ev = events[selectedDate][index];
  const newText = prompt('Editar evento:', ev.text);
  const newTime = prompt('Editar horário (HH:MM):', ev.time);

  if (newText !== null && newText.trim() !== '') {
    ev.text = newText.trim();
  }
  if (newTime !== null && /^\d{2}:\d{2}$/.test(newTime)) {
    ev.time = newTime;
  }

  saveEvents();
  renderEvents();
}*/

function editEvent(index) {
  const ev = events[selectedDate][index];
  const newText = prompt('Editar nome do cliente:', ev.text);
  const newTime = prompt('Editar horário (HH:MM):', ev.time);
  const newService = prompt('Editar serviço:', ev.service || '');

  if (newText !== null && newText.trim() !== '') {
    ev.text = newText.trim();
  }
  if (newTime !== null && /^\d{2}:\d{2}$/.test(newTime)) {
    ev.time = newTime;
  }
  if (newService !== null && newService.trim() !== '') {
    ev.service = newService.trim();
  }

  saveEvents();
  renderEvents();
}


/*addEventBtn.addEventListener('click', () => {
  const text = eventInput.value.trim();
  const time = eventTime.value;

  if (!selectedDate) {
    alert('Selecione um dia no calendário!');
    return;
  }
  if (!text) {
    alert('Digite um evento!');
    return;
  }
  if (!time) {
    alert('Informe o horário do evento!');
    return;
  }

  if (!events[selectedDate]) {
    events[selectedDate] = [];
  }
  events[selectedDate].push({ text, time });
  eventInput.value = '';
  eventTime.value = '';
  saveEvents();
  renderEvents();
});*/

addEventBtn.addEventListener('click', () => {
  if (!selectedDate) {
    alert('Por favor, selecione um dia no calendário.');
    return;
  }

  const time = eventTime.value;
  const text = eventInput.value.trim();
  const service = eventService.value;

  if (!time || !text || !service) {
    alert('Por favor, preencha todos os campos.');
    return;
  }

  const event = { time, text, service };

  if (!events[selectedDate]) {
    events[selectedDate] = [];
  }

  events[selectedDate].push(event);
  saveEvents();
  renderEvents();

  eventInput.value = '';
  eventTime.value = '';
  eventService.value = '';
});


prevBtn.addEventListener('click', () => {
  date.setMonth(date.getMonth() - 1);
  renderCalendar();
});

nextBtn.addEventListener('click', () => {
  date.setMonth(date.getMonth() + 1);
  renderCalendar();
});

renderCalendar();
renderEvents();
