
import React from 'react';
import PropTypes from 'prop-types';
import Thread from '../commons/thread';

const TopicsList = ({topics, titleGroup}) => {
    const el = topics.map(t => <Thread key={t.id} topic={t}/>);

    return (
        <div className="card">
            <div className="card-header">
                {titleGroup}
            </div>
            <ul className="list-group list-group-flush">
                {el}
            </ul>
        </div>
    );
};

TopicsList.propTypes = {
    topics: PropTypes.array.isRequired,
    titleGroup: PropTypes.string.isRequired
};

export default TopicsList;