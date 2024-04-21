import React, { useEffect, useState } from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button'

export const Task = () => {
    const [tasks, setTasks] = useState([]);
    // useEffect(() => {
    //     fetch('http://localhost:8080/api/task', {
    //         method: "POST",
    //         headers: {
    //             'Content-Type': 'application/json', // Chỉ định định dạng JSON
    //         }
    //     })
    //         .then(res => res.json())
    //         .then(tasks => {
    //             setTasks(tasks)
    //         })
    // }, [])

    const handleSubmit = (event) => {
        event.preventDefault();

        const tasks = JSON.stringify(tasks); // Chuyển đổi dữ liệu sang định dạng JSON

        fetch('/api/submit-form', {
        
            method: 'POST',
            headers: {
                'Content-Type': 'application/json', // Chỉ định định dạng JSON
            },
            body: tasks,
        })
            .then((response) => response.json())
            .then((tasks) => {
                console.log('Submit form successfully:', tasks);
            })
            .catch((error) => {
                console.error('Submit form error:', error);
            });
    };


    return (
        <div className="task mb-5">
            <Form action='http://localhost:8080/api/task' method='post'onSubmit={handleSubmit}>
                <Form.Group>
                    <Form.Label className='my-5 h1'>Todo List</Form.Label>
                </Form.Group>
                <Form.Group className='d-flex'>
                    <Form.Control className='px-4 py-2' 
                        type='text' id='task_name' 
                        name='task_name' 
                        placeholder='Add New Task' 
                        onChange={(event) => setTasks({ ...tasks, name: event.target.value })}
                    />
                    <Button className='w-25' type='submit' style={{border: "none", background: "orange"}}>Submit</Button>
                </Form.Group>
            </Form>
        </div>
    )
} 
