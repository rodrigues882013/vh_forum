import React from 'react';
import { NavLink } from 'react-router-dom';


const ForumCategory = ({category}) => {
    return (
        <NavLink to={`/category/${category.id}`} className="list-group-item list-group-item-action">
            {category.name}
        </NavLink>
    )
};

export default ForumCategory;