const apiUrl = "http://localhost:9090/tasks";

async function loadTasks() {
  const response = await fetch(apiUrl);
  const tasks = await response.json();
  const taskList = document.getElementById("taskList");
  taskList.innerHTML = "";

  tasks.forEach(task => {
    const li = document.createElement("li");
    li.innerHTML = `
      <strong>${task.title}</strong> - ${task.description} - ${task.status}
      <button onclick="showUpdateForm(${task.id}, '${task.title}', '${task.description}', '${task.status}')">Actualizar</button>
      <button onclick="deleteTask(${task.id})">Eliminar</button>
    `;
    taskList.appendChild(li);
  });
}

document.getElementById("createTaskForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const task = {
    title: document.getElementById("title").value,
    description: document.getElementById("description").value,
    status: document.getElementById("status").value
  };

  await fetch(apiUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task)
  });

  e.target.reset();
  loadTasks();
});

function showUpdateForm(id, title, description, status) {
  document.getElementById("updateTaskForm").style.display = "block";
  document.getElementById("updateId").value = id;
  document.getElementById("updateTitle").value = title;
  document.getElementById("updateDescription").value = description;
  document.getElementById("updateStatus").value = status;
}

document.getElementById("updateTaskForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const id = document.getElementById("updateId").value;
  const task = {
    title: document.getElementById("updateTitle").value,
    description: document.getElementById("updateDescription").value,
    status: document.getElementById("updateStatus").value
  };

  await fetch(`${apiUrl}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task)
  });

  e.target.reset();
  document.getElementById("updateTaskForm").style.display = "none";
  loadTasks();
});

async function deleteTask(id) {
  await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
  loadTasks();
}

window.onload = loadTasks;
