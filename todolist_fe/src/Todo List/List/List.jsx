import React, { useEffect, useState } from 'react'
import Table from 'react-bootstrap/Table'
import Button from 'react-bootstrap/Button'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

export const List = () => {
  const [tasks, setTasks] = useState([])
  const [checkTask, setCheckTask] = useState([])

  // get tasks
  useEffect(() => {
    fetch('http://localhost:8080/api/task', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json', // Chỉ định định dạng JSON
      }
    })
      .then(res => res.json())
      .then(tasks => {
        setTasks(tasks)
        console.log(tasks)
      })
  }, [])


  // check task


  // delete task
  return (
    <div className='list'>
      <Table hover>
        <thead>
          <tr>
            <th>Task Name</th>
            <th>Active</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((tasks, task_id) => {
            return <tr key={task_id}>
              <td>{tasks.task_name}</td>
              <td>
                <Button className='bg-secondary border '>
                  <i class="fa-solid fa-check"></i>
                </Button>
                <Button className='bg-danger border '>
                  <i class="fa-solid fa-trash"></i>
                </Button>
              </td>
            </tr>
          })}
        </tbody>
      </Table>
    </div>
  )
}
