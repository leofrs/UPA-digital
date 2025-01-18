import React, { useState } from 'react';

const CalendarPatient = ({ tasks = [] }) => {
  const [currentDate, setCurrentDate] = useState(new Date());
  const [selectedDate, setSelectedDate] = useState(null);

  const getDaysInMonth = (year, month) => {
    return new Date(year, month + 1, 0).getDate();
  };

  const formatDate = (date) => {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  };

  const getTasksForDate = (date) => {
    if (!Array.isArray(tasks)) return [];
    return tasks.filter((task) => task.date === date);
  };

  const renderDays = () => {
    const year = currentDate.getFullYear();
    const month = currentDate.getMonth();
    const daysInMonth = getDaysInMonth(year, month);
    const firstDayOfMonth = new Date(year, month, 1).getDay();

    const days = [];

    // Preencher os dias em branco no início do mês
    for (let i = 0; i < firstDayOfMonth; i++) {
      days.push(<div key={`empty-${i}`} className="w-10 h-10" />);
    }

    // Preencher os dias do mês
    for (let day = 1; day <= daysInMonth; day++) {
      const currentDay = new Date(year, month, day);
      const formattedDate = formatDate(currentDay);
      const hasTasks = getTasksForDate(formattedDate).length > 0;
      const today = new Date();
      const isToday = formatDate(currentDay) === formatDate(today);
      const isSelected = formattedDate === selectedDate;

      days.push(
        <div
          key={day}
          className={`w-10 h-10 flex items-center justify-center cursor-pointer rounded-md border
            ${isToday ? 'bg-blue-500 text-white' : ''}
            ${hasTasks ? 'bg-green-200 text-green-800' : ''}
            ${isSelected ? 'ring-2 ring-blue-500' : ''}`}
          onClick={() => setSelectedDate(formattedDate)}
        >
          {day}
        </div>
      );
    }

    return days;
  };

  const formatDisplayDate = (dateString) => {
    const [year, month, day] = dateString.split('-');
    const date = new Date(parseInt(year), parseInt(month) - 1, parseInt(day));
    return date.toLocaleDateString('pt-BR');
  };

  return (
    <div className="flex gap-6 p-4">
      {/* Calendar Section */}
      <div className="flex flex-col items-center">
        <div className="flex items-center justify-between w-full max-w-md mb-4">
          <button
            className="p-2 bg-gray-200 rounded hover:bg-gray-300"
            onClick={() => setCurrentDate(new Date(currentDate.getFullYear(), currentDate.getMonth() - 1, 1))}
          >
            &#8592;
          </button>
          <h2 className="text-lg font-semibold">
            {currentDate.toLocaleString('pt-BR', { month: 'long' })} {currentDate.getFullYear()}
          </h2>
          <button
            className="p-2 bg-gray-200 rounded hover:bg-gray-300"
            onClick={() => setCurrentDate(new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 1))}
          >
            &#8594;
          </button>
        </div>
        <div className="grid grid-cols-7 gap-2">
          <div className="text-center font-semibold">Dom</div>
          <div className="text-center font-semibold">Seg</div>
          <div className="text-center font-semibold">Ter</div>
          <div className="text-center font-semibold">Qua</div>
          <div className="text-center font-semibold">Qui</div>
          <div className="text-center font-semibold">Sex</div>
          <div className="text-center font-semibold">Sáb</div>
          {renderDays()}
        </div>
      </div>

      {/* Tasks Section */}
      <div className="w-9/12 min-h-full">
        {selectedDate ? (
          <div className="p-4 bg-gray-100 rounded shadow-md h-full">
            <h3 className="text-lg font-semibold mb-4">
              Consultas do dia: {formatDisplayDate(selectedDate)}
            </h3>
            {getTasksForDate(selectedDate).length > 0 ? (
              <ul className="list-disc list-inside space-y-2">
                {getTasksForDate(selectedDate).map((task, index) => (
                  <li key={index} className="text-gray-700">{task.description}</li>
                ))}
              </ul>
            ) : (
              <p className="text-gray-500">Você não possui nenhuma consulta marcada nesse dia</p>
            )}
          </div>
        ) : (
          <div className=" w-9/12 p-4 bg-gray-100 rounded shadow-md h-full">
            <p className="text-gray-500">Selecione uma data para ver as tarefas.</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default CalendarPatient;