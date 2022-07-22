import React from 'react';

interface Prop {
  placeholder: string;
  type: string;
}

export default function Input(props: Prop) {
  return <input type={props.type} placeholder={props.placeholder} />;
}
