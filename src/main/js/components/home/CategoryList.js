
import React from 'react';
import PropTypes from 'prop-types';
import ForumCategory from '../commons/forum-category';

const CategoryList = ({categories}) => {
    const el = categories.map(c => <ForumCategory key={c.id} category={c}/>);

    return (
        <div className="card">
            <div className="card-header">
                Forums
            </div>
            <ul className="list-group list-group-flush">
                {el}
            </ul>
        </div>
    );
};

CategoryList.propTypes = {
    categories: PropTypes.array.isRequired

};

export default CategoryList;