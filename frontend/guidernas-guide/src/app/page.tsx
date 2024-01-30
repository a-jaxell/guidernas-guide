
import React from 'react'
import ActivityCreateForm from '../components/ActivityForm/ActivityForm'
import Layout from './layout'

export default function Page(){
  return (
    <Layout>
        <div className="flex flex-col items-center justify-center h-full">
            <h1 className='text-4xl'>Test</h1>
            <ActivityCreateForm />
        </div>
        
    </Layout>
  )
}
